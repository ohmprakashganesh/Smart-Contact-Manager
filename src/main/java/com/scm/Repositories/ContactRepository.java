package com.scm.Repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.entities.Contact;
import com.scm.entities.User;
@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {
    
    //find the contact by user 

    Page <Contact> findByUser(User user,Pageable pageable);

    Page <Contact> findByUserAndNameContaining(User user,String nameKeyword, Pageable pageable);
    Page <Contact> findByUserAndEmailContaining(User user,String emailKeyword, Pageable pageable);
    Page<Contact> findByUserAndPhoneNumberContaining( User user,String phoneNumberKeyword, Pageable pageable );

    //custom query method
    @Query("SELECT c FROM Contact c WHERE c.user.id= :userId")
    List<Contact> findByUserId(@Param("userid") Long uid);


     
}
