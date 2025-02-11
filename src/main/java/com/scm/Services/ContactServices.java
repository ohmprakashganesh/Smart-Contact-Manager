package com.scm.Services;

import java.util.List;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactServices {

    Contact saveContact(Contact contact);
    Contact updContact(Contact contact, Long id);
    List<Contact> allContacts();
     Contact getContact(Long id);
     void deleteContact(Long id);
     List<Contact> getByUserId(Long id);
     List<Contact> getByUser(User user);


     List<Contact> search(String name,String email, String phoneNumber );
    
}
