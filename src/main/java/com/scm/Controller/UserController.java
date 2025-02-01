package com.scm.Controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.Services.UserServices;
import com.scm.entities.User;
import com.scm.helpers.Helper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

   private final UserServices services;
    // private Logger logger=LoggerFactory.getLogger(UserController.class);
    
    // @ModelAttribute
    // public void AddLoggedInUserInfo(Model model,Authentication auth){
    //     String name= Helper.getEmailOfLoggedUser(auth);
    //     User user= services.getUserByEmail(name);
    //     model.addAttribute("user", user);
    //     System.out.println(user);   
    //  System.err.println("this is printing of the name of logged user "+ name );

    // }

    @RequestMapping("/dashboard")
    public String  userDashboard(){
        System.out.println("user  page is initialized");
        return "user/dashboard";
    }

    @RequestMapping("/profile")
    public String  userProfile(Model model, Authentication authentication){
   
        // logger.info(name);
        return "user/userProfile";
    }



    //user add contacts

    //user view contact

    //user delete contacts
}
