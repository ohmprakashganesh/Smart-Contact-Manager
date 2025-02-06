package com.scm.forms;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class ContactForm {

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
    private boolean favorite;
    private String link1;
    private String link2;


    private MultipartFile  profileImg;
    
}
