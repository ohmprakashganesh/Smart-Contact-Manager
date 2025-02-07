package com.scm.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.Services.UserServices;
import com.scm.entities.User;
import com.scm.helpers.Helper;

import lombok.AllArgsConstructor;

@ControllerAdvice
@AllArgsConstructor
public class Rootcontroller {

       private final UserServices services;


    @ModelAttribute
    public void AddLoggedInUserInfo(Model model,Authentication auth){
        if(auth==null){
            return; 
        }
        String name= Helper.getEmailOfLoggedUser(auth);
        User user= services.getUserByEmail(name);
    
        model.addAttribute("user", user);
        System.out.println(user);   
     System.err.println("this is printing of the name of logged user "+ name );

    }

    
}
