package com.scm.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.Repositories.UserRepository;
import com.scm.Services.UserServices;
import com.scm.entities.User;
import com.scm.helpers.AppConstants;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServices{

    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;




    @Override
    public User saveUser(User user) {
        //incode pass to sasve before
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //set role by default
        user.setRoles(List.of(AppConstants.APP_NAME,AppConstants.ROLE_USER));
       return userRepository.save(user);

       
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optional= userRepository.findById(id);
       if(optional.isPresent()){
        return optional.get();

       }else{
        throw new EntityNotFoundException("not found"+id);
       }
        
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
      }

  

    @Override
    public boolean isUserExist(Long UserId) {
        Optional<User> optional= userRepository.findById(UserId);
        if(optional.isPresent()){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public boolean isUserExistByUserEmail(String email) {
        Optional<User> optional= userRepository.findByEmail(email);
        if(optional.isPresent()){
            return true;
        }else{
            return false;
        }
       
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
       
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
        .orElse(null);
    }
    

    
}
