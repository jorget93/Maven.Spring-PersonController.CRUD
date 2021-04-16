package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    public PersonController(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    @Autowired
    PersonRepository personRepo;

    @PostMapping(value = "/people")
    public Person createPerson(Person p ){
        return personRepo.save(p);
    }

    @GetMapping(value = "/people/{id}")
    public Person getPerson(@PathVariable Long id){
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
    public Person updatePerson(Person p, @PathVariable Long id){
        Person holder = personRepo.findOne(id);
        holder.setFirstName(p.getFirstName());
        holder.setLastName(p.getLastName());
        return personRepo.save(holder);
    }

    @DeleteMapping(value = "/people/{id}")
    public void DeletePerson(@PathVariable Long id){
        for(Person p: personRepo.findAll()){
            if(p.getIdNumber().equals(id)){
                personRepo.delete(p);
            }
        }
    }
}
