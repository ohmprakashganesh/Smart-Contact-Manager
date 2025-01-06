package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page is here ");
        model.addAttribute("name", "Om prakash ganesh" );
        model.addAttribute("age", "55");
        return "home";

    }
    
}
