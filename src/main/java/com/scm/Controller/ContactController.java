package com.scm.Controller;

import java.util.logging.Logger;
import java.util.List;
import java.util.UUID;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Services.ContactServices;
import com.scm.Services.ImageService;
import com.scm.Services.UserServices;
import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.forms.ContactForm;
import com.scm.helpers.Helper;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;







@AllArgsConstructor
@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ImageService imageService;

    private final ContactServices contactServices;
    private final UserServices userServices;


    //page rendering APIs

    @RequestMapping("/add")
    public String contactFormCall(Model model) {
        ContactForm contact = new ContactForm();
        contact.setName("John Doe");
        contact.setEmail("johndoe@example.com");
        contact.setPhoneNumber("1234567890");
        contact.setAddress("123 Main St, City, Country");
        contact.setDescription("Friend from college");
        contact.setFavorite(false);
        contact.setLink1("https://linkedin.com/in/johndoe");
        contact.setLink2("https://github.com/johndoe");
        model.addAttribute("contactForm", contact);

         return "user/addContact";
    }

    @GetMapping("/all")
    public String getContacts(Authentication authentication , Model model) {

        String username= Helper.getEmailOfLoggedUser(authentication);
        User user= userServices.getUserByEmail(username);

       List<Contact> byUser= contactServices.getByUser(user);
       System.out.println("Contacts fetched: " + byUser.size()); // Debugging

       for (Contact contact : byUser) {
        System.out.println(contact);

        System.out.println(contact.getPicture());


        
       }



   

       model.addAttribute("contacts", byUser);

       System.out.println("all contact data load by user"+user.toString());
       return "user/allContacts";
    }


    
    @GetMapping("/single")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    


    
    @RequestMapping(value ="/postContact", method = RequestMethod.POST)
    public String addContact (@Valid @ModelAttribute ContactForm contactForm, BindingResult result, Authentication authentication, HttpSession session) {

     
        if(result.hasErrors()){
            return "user/addContact";
        }

        String username= Helper.getEmailOfLoggedUser(authentication);
        User user= userServices.getUserByEmail(username);


        String fileName= UUID.randomUUID().toString();
           //process the image 

           System.out.println("name file is "+ contactForm.getProfileImg().getOriginalFilename());

         String url = imageService.uploadImage(contactForm.getProfileImg(),fileName);
           


           
        Contact contact= new Contact();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setFavorite(false);
        contact.setPicture(url);
        contact.setLink1(contactForm.getLink1());
        contact.setLink2(contactForm.getLink2());
        //set the user 
        contact.setUser(user);

        //set the profile picture 
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contactServices.saveContact(contact);

        System.out.println("form submitted successfully  ");
 Message message= Message.builder().content("contact adding sucessfull").type(MessageType.green).build();
      session.setAttribute("message", message);  
             return "user/addContact";

    }
    
    @DeleteMapping("/delete")
    public void deleteById(){
        System.out.println("deleted is clicked");
    }

 
    

    
    
}
