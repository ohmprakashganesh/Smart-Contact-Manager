package com.scm.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactServices {

    Contact saveContact(Contact contact);
    Contact updContact(Contact contact, Long id);
    List<Contact> allContacts();
     Contact getContact(Long id);
     void deleteContact(Long id);
     List<Contact> getByUserId(Long id);
     Page<Contact> getByUser(User user , int page , int size, String field, String direction );


     List<Contact> search(String name,String email, String phoneNumber );
    
}
