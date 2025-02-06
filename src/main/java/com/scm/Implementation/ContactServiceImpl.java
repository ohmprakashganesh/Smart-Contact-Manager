package com.scm.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Repositories.ContactRepository;
import com.scm.Services.ContactServices;
import com.scm.entities.Contact;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactServices {
    
    private final ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        

      
        throw new UnsupportedOperationException("Unimplemented method 'saveContact'");
    }

    @Override
    public Contact updContact(Contact contact, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updContact'");
    }

    @Override
    public List<Contact> allContacts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allContacts'");
    }

    @Override
    public Contact getContact(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContact'");
    }

    @Override
    public void deleteContact(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteContact'");
    }

    @Override
    public List<Contact> search(String name, String email, String phoneNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
