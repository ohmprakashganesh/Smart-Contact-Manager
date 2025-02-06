package com.scm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {
    

     
}
