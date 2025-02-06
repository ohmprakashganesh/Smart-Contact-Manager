package com.scm.Services;

import java.util.List;

import com.scm.entities.Contact;

public interface ContactServices {

    Contact saveContact(Contact contact);
    Contact updContact(Contact contact, Long id);
    List<Contact> allContacts();
     Contact getContact(Long id);
     void deleteContact(Long id);
     List<Contact> search(String name,String email, String phoneNumber );
    
}
