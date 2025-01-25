package com.scm.Controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.helpers.Helper;



@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger=LoggerFactory.getLogger(UserController.class);
    

    @RequestMapping("/dashboard")
    public String  userDashboard(){
        System.out.println("user  page is initialized");
        return "user/dashboard";
    }

    @RequestMapping("/profile")
    public String  userProfile(Authentication authentication){
        String name= Helper.getEmailOfLoggedUser(authentication);
        
        System.err.println("this is printing of the name of logged user "+ name );
        logger.info(name);
        return "user/userProfile";
    }



    //user add contacts

    //user view contact

    //user delete contacts
}
