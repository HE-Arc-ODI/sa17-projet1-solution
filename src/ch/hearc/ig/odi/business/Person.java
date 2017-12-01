/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Project: Marathon
 * Autor: Myriam Schaffter
 * Date: 17.11.17 11:52
 * Module: sa17-projet1
 */

package ch.hearc.ig.odi.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Person")
public class Person implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateBirth;
    private List listCategory;

    public Person(){
        this.listCategory = new ArrayList();
    }

    public Person(Long id, String firstName, String lastName, Date dateBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.listCategory = new ArrayList();
    }

    @XmlTransient
    @JsonIgnore
    public List getListCategory() {
        return listCategory;
    }

    public void setListCategory(List listCategory) {
        this.listCategory = listCategory;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void addMarathon(Category category){
        this.listCategory.add(category);
    }
}
