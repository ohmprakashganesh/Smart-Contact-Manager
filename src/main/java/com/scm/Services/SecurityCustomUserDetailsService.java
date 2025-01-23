package com.scm.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.Repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityCustomUserDetailsService implements UserDetailsService {
   
    final private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository.findByEmail(username).
      orElseThrow(()->new UsernameNotFoundException(username+ "user of this name does not exist in the system"));
    }

    
}
