package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class UserController {
    

    @RequestMapping("/dashboard")
    public String  userDashboard(){
        System.out.println("user  page is initialized");
        return "user/dashboard";
    }

    @RequestMapping("/profile")
    public String  userProfile(){
        System.out.println("user  page is initialized");
        return "user/userProfile";
    }



    //user add contacts

    //user view contact

    //user delete contacts
}
