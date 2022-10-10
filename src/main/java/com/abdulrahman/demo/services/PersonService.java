package com.abdulrahman.demo.services;


import com.abdulrahman.demo.dao.PersonDao;
import com.abdulrahman.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    // CREATE PERSON
    public Person createPerson(Person person){
        int numOfPeople = personDao.findAll().size();
        person.setId(numOfPeople+1);
        return personDao.save(person);
    }

    // GET ALL PEOPLE IN DATABASE
    public List<Person> getPeople() {
        return personDao.findAll();
    }

    // GET PERSON BY ID
    public Person getPerson(Integer id){
        return personDao.findById(id).get();
    }

    // DELETE PERSON
    public void deletePerson(Integer id){
        personDao.deleteById(id);
        System.out.println("Person with ID: "+
                           id+" has been deleted.");
    }

    // UPDATE PERSON
    public Person updatePerson(Integer id, Person person){
        Person existedPerson = personDao.findById(id).get();
        existedPerson.setName(person.getName());
        existedPerson.setAddress(person.getAddress());
        existedPerson.setPostcode(person.getPostcode());
        existedPerson.setAge(person.getAge());
        existedPerson.setJob(person.getJob());
        existedPerson.setEmail(person.getEmail());
        existedPerson.setPhoneno(person.getPhoneno());

        return personDao.save(existedPerson);
    }


}