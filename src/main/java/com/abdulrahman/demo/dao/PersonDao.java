package com.abdulrahman.demo.dao;

import com.abdulrahman.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository< Person, Integer > {
    
}
