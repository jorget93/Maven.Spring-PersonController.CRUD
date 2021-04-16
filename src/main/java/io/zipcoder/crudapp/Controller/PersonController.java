package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepo;

    @PostMapping(value = "/person")
    public Person createPerson(Person p ){
        return personRepo.save(p);
    }

    @GetMapping(value = "/people/{id}")
    public Person getPerson(Long id){
        return personRepo.findOne(id);
    }

    @GetMapping(value = "/people")
    public List<Person> getPersonList(){
        List<Person> people = new ArrayList<>();
        for(Person p: personRepo.findAll()){
            people.add(p);
        }
        return people;
    }

    @PutMapping(value = "/people/{id}")
    public Person updatePerson(Person p){
        Person holder = personRepo.findOne(p.getIdNumber());
        holder.setFirstName(p.getFirstName());
        holder.setLastName(p.getLastName());
        return p;
    }

    @GetMapping(value = "/people/{id}")
    public void DeletePerson(int id){
        for(Person p: personRepo.findAll()){
            if(p.getIdNumber().equals(id)){
                personRepo.delete(p);
            }
        }
    }
}
