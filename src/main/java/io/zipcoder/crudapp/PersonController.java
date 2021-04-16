package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
    List<Person> personList = new ArrayList<>();

    public Person createPerson(Person p ){
        return p;
    }

    public Person getPerson(int id){
        for(Person p: personList){
            if(p.getIdNumber().equals(id)){
                return p;
            }
        }
        return null;
    }

    public List<Person> getPersonList(){
        return personList;
    }

    public Person updatePerson(Person p){
        return p;
    }

    public void DeletePerson(int id){
        for(Person p: personList){
            if(p.getIdNumber().equals(id)){
                personList.remove(p);
            }
        }
    }
}
