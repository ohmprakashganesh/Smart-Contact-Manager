package com.scm.forms;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class ContactForm {

    @NotBlank(message = "fill the name")
    private String name;
    @Email(message = "invlaid email")
    private String email;

    private String phoneNumber;
    private String address;

    private String description;
    private boolean favorite;
    private String link1;
    private String link2;


    private MultipartFile  profileImg;
    
}
