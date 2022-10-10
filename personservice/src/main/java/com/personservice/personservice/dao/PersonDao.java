package com.personservice.personservice.dao;

import com.personservice.personservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository< Person, Integer > {
    
}
