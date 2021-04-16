package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {



}
