package com.scm.Implementation;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scm.Repositories.ContactRepository;
import com.scm.Services.ContactServices;
import com.scm.entities.Contact;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactServices {
    
    final private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
       return contactRepository.save(contact);
    }

    @Override
    public Contact updContact(Contact contact, Long id) {
      Optional<Contact> optional=contactRepository.findById(id);
      if(optional.isPresent()){
      return  optional.get();
      }else{
        throw new EntityNotFoundException("entity of id "+id+ "not found");

      }

    }

    @Override
    public List<Contact> allContacts() {
      return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) {
        // TODO Auto-generated method stub
        Optional<Contact> optional=contactRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new EntityNotFoundException("entity not found");
        }
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
        System.out.println("delete the item of id "+ id);
    }

    @Override
    public List<Contact> search(String name, String email, String phoneNumber) {
       return null;
    }

    @Override
    public List<Contact> getByUserId(Long id) {
        return contactRepository.findByUserId(id);
    }
    
}
