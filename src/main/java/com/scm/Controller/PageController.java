package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class PageController {


    @RequestMapping("/home")
    public String  aboutPage(){
        System.out.println("about page is initialized");
        return "home";
    }
    @RequestMapping("/about")
    public String  aboutPage2(){
        System.out.println("about page is initialized");
        return "about";
    }
    @RequestMapping("/services")
    public String  aboutPage3(){
        System.out.println("about page is initialized");
        return "services";
    }

    @RequestMapping("/contact")
    public String  contactpage(){
        System.out.println("about page is initialized");
        return "contact";
    }

    @RequestMapping("/login")
    public String  loginPage(){
        System.out.println("about page is initialized");
        return "login";
    }

    @RequestMapping("/signup")
    public String  signUp(){
        System.out.println("about page is initialized");
        return "register";
    }

    
}

