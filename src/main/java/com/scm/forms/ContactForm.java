package com.scm.forms;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ContactForm {

    @NotBlank(message = "fill the name")
    private String name;

    @Email(message = "invalid email")
    @NotBlank(message = "please fill")
    private String email;

   @Size(min = 10, max = 10,message = "only 10 digit")
    private String phoneNumber;

    @NotBlank(message = "fill the name")
    private String address;

    private String description;
    private boolean favorite;
    private String link1;
    private String link2;


    private MultipartFile  profileImg;
    
}
