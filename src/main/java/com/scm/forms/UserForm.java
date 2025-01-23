package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
    @NotBlank(message = "fill your name")
    private String name;
    @Email
    @NotBlank(message = "please fill  email")
    private String email;
    @NotBlank(message = "required")
    @Size(min = 4 , max = 10, message = "between 4 to 10")
    private String password;
    @NotNull
    @Size(min = 10 , max = 10,message = "require 10 digit")
    private String phoneNumber;
    @NotBlank(message = "write description")
    private String about;

    
}
