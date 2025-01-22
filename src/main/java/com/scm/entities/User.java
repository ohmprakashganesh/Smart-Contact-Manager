package com.scm.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class User {

 
    @Id
    private String userId;
    @Column(nullable =false)
    private String name;
    @Column(nullable =false, unique = true)
    private String emial;
    private String password;
    private String about;
    private String profilePic;

//information
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

//method of signup 
private Providers provider=Providers.SELF;
private String providerUserId;
    

//mapping of data 

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY )
 private List<Contact> contact= new ArrayList<>();



}
