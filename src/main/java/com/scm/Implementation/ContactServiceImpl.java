package com.scm.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.scm.Repositories.ContactRepository;
import com.scm.Services.ContactServices;
import com.scm.entities.Contact;
import com.scm.entities.User;

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

    @Override
    public List<Contact> allContacts() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'allContacts'");
    }

    
    @Override
    public org.springframework.data.domain.Page<Contact> getByUser(User user,int page, int size, String sortBy, String direct) {
      Sort sort=direct.equals("desc") ?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
      var Pageable= PageRequest.of(page, size , sort);
      return contactRepository.findByUser(user, Pageable);
   
    }

  

 
    
}
