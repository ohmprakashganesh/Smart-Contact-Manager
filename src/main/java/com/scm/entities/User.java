package com.scm.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;



@Entity
@Data
public class User implements UserDetails{

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(nullable =false)
    private String name;
    @Column(nullable =false, unique = true)
    private String email;
    private String password;
    private String about;
    private String profilePic;
    private List<String>  roles;
    private String phoneNumber;

//information
    private boolean enabled=true;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

//method of signup
@Enumerated(value = EnumType.STRING)
private Providers provider=Providers.SELF;
private String providerUserId;

//mapping of data

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY )
private List<Contact> contact= new ArrayList<>();

@ElementCollection(fetch = FetchType.EAGER)
private List<String> list= new ArrayList<>();

 public Collection<? extends GrantedAuthority> getAuthorities(){
    Collection<SimpleGrantedAuthority>roles=  list.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    return   roles;
 }

@Override
 public String getPassword(){
    return this.password;
 }

 @Override
 public String getUsername(){
    return this.email;
 }

@Override
 public boolean isAccountNonExpired() {
     return true;
 }

 @Override
 public boolean isAccountNonLocked() {
     return true;
 }

 @Override
 public boolean isCredentialsNonExpired() {
     return true;
 }

@Override
 public boolean isEnabled() {
     return this.enabled;
 }



}
