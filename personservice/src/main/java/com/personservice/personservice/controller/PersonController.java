package com.personservice.personservice.controller;


import com.personservice.personservice.model.Person;
import com.personservice.personservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    // CREATE PERSON
    @RequestMapping(value="/person", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public Person savePerson(@RequestBody Person person){
        System.out.println(person.getId());
        return personService.createPerson(person);
    }

    // GET Specific person with id
    @RequestMapping(value = "/item/person{id}", method = RequestMethod.GET,produces="application/json")
    public Person getPerson(@PathVariable("id") Integer id){

        return personService.getPerson(id);
    }

    // GET all people
    @RequestMapping(value = "/persons/person", method = RequestMethod.GET,produces="application/json")
    public List<Person> getAllPeople(){

        return personService.getPeople();
    }

    // DELETE person
    @RequestMapping(value = "/persons/person", method = RequestMethod.DELETE,consumes="application/json")
    public void deletePerson(@RequestBody Person person){
        personService.deletePerson(person);
    }

    // UPDATE person
    @RequestMapping(value="/persons/person", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person.getId(), person);
    }

}
