/**
 * REF: http://www.sortedset.com/embedded-tomcat-jersey/
 * REF: https://stackoverflow.com/questions/23304404/trouble-creating-a-simple-singleton-class-in-jersey-2-using-built-in-jersey-depe
 */

package ch.hearc.ig.odi.launcher;

import java.io.File;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Starts the embedded tomcat server with the appropriate configuration.
 */
public class Main {

  public static void main(String[] args) throws Exception, LifecycleException {
    new Main().start();
  }

  public void start() throws ServletException, LifecycleException,
      MalformedURLException {

    // Define a folder to hold web application contents.
    String webappDirLocation = "WebContent/";
    Tomcat tomcat = new Tomcat();

    // Define port number for the web application
    String webPort = System.getenv("PORT");
    if (webPort == null || webPort.isEmpty()) {
      webPort = "8888";
    }
    // Bind the port to Tomcat server
    tomcat.setPort(Integer.valueOf(webPort));

    // Define a web application context.
    // contextPath represents the base URI for the application.
    Context context = tomcat.addWebapp("/tomcatembedded", new File(
        webappDirLocation).getAbsolutePath());

    // Define and bind web.xml file location.
    File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
    context.setConfigFile(configFile.toURI().toURL());

    tomcat.start();
    tomcat.getServer().await();
  }

}