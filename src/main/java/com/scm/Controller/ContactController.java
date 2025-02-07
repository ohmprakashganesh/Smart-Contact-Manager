package com.scm.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Services.ContactServices;
import com.scm.Services.UserServices;
import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.forms.ContactForm;
import com.scm.helpers.Helper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;





@AllArgsConstructor
@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactServices contactServices;
    private final UserServices userServices;

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
    public String addContact (@ModelAttribute ContactForm contactForm,@Valid BindingResult result, Authentication authentication) {

     
        if(result.hasErrors()){
            return "user/addContact";
        }

        String username= Helper.getEmailOfLoggedUser(authentication);
        User user= userServices.getUserByEmail(username);

           //process the image 
        Contact contact= new Contact();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setFavorite(contactForm.isFavorite());
        //set the user 
        contact.setUser(user);

        //set the profile picture 
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contactServices.saveContact(contact);

        System.out.println("form submitted successfully  ");
         return "user/addContact";

    }

 
    

    
    
}
