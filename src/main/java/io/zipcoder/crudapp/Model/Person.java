package io.zipcoder.crudapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String firstName;
    private String lastName;

    public Person (Long idNumber, String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = idNumber;
    }

    public Person() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdNumber() {
        return id;
    }

    public void setIdNumber(Long idNumber) { this.id = idNumber;}
}
