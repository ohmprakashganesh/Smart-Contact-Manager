package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Services.UserServices;
import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;





@Controller
@AllArgsConstructor
public class PageController {

    final private  UserServices userServices;


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
    public String  signUp(Model model){

        UserForm temp= new UserForm();
        temp.setEmail(null);
        temp.setAbout(null);
        temp.setPassword(null);
        temp.setPhoneNumber(null);
        temp.setName(null);
        model.addAttribute("userForm", temp);
        System.out.println("about page is initialized");
        return "register";
    }


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String  registerFun(@Valid  @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){

        System.out.println("about page is initialized"+ userForm);

        //setting for remin is screen value
        // UserForm temp= new UserForm();
        // temp.setEmail(userForm.getEmail());
        // temp.setAbout(userForm.getAbout());
        // temp.setPassword(userForm.getPassword());
        // temp.setPhoneNumber(userForm.getPhoneNumber());
        // temp.setName(userForm.getName());
        // model.addAttribute("userForm", userForm);

       

        //fetch
        //validate
        if(rBindingResult.hasErrors()){
            return "register";
        }

        
        User user=new User();
        user.setName(userForm.getName());

         user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.pexels.com/photo/green-and-blue-peacock-feather-674010/");
       
        userServices.saveUser(user);

        //save to db
        
        //message
       Message message= Message.builder().content("registeration sucessfull").type(MessageType.green).build();
      session.setAttribute("message", message);

        return "redirect:/signup";
    }


    @RequestMapping("/addContact")
    public String  addContactFun(){
        System.out.println("add form is  page is initialized");
        return "user/addContact";
    }

    @RequestMapping("/allContacts")
    public String  allContactsFun(){
        System.out.println("add form is  page is initialized");
        return "user/allContacts";
    }


}

