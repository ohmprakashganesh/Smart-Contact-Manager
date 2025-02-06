package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.ContactForm;




@Controller
@RequestMapping("/contact")
public class ContactController {

    @RequestMapping("/add")
    public String contactFormCall(Model model) {
        ContactForm contact = new ContactForm();
        contact.setName("John Doe");
        contact.setEmail("johndoe@example.com");
        contact.setPhoneNumber("1234567890");
        contact.setAddress("123 Main St, City, Country");
        contact.setDescription("Friend from college");
        contact.setFavorite(true);
        contact.setLink1("https://linkedin.com/in/johndoe");
        contact.setLink2("https://github.com/johndoe");
        model.addAttribute("contactForm", contact);
         return "user/addContact";
        
       
    }
    
    @RequestMapping(value ="/postContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute ContactForm contactForm) {
        System.out.println("this is running of this page ");
       System.out.println(contactForm);
         return "user/addContact";
        
       
    }

    
    
}
