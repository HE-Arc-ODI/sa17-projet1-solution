package ch.hearc.ig.odi.rest.resources;

import ch.hearc.ig.odi.service.RestService;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Example REST resource using injection of the mock persistence service
 */
@Named
@Path("/helloworld")
public class HelloWorldRestResource {

  @Inject
  private RestService service;

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public int sayHello() {
    return service.getHashCode();
  }



}