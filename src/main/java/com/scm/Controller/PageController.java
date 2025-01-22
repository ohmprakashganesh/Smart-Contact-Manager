package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Services.UserServices;
import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import jakarta.servlet.http.HttpSession;
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
        UserForm userForm= new UserForm();
        userForm.setEmail("homo");
        userForm.setAbout("hello how are you ");
        userForm.setPassword("4894u4dkf");
        userForm.setPhoneNumber("98548549");
        userForm.setName("om");
        model.addAttribute("userForm", userForm);
        System.out.println("about page is initialized");
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String  registerFun(@ModelAttribute UserForm userForm, HttpSession session){

        System.out.println("about page is initialized"+ userForm);

        User user=new User();
        user.setName(userForm.getName());

         user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.pexels.com/photo/green-and-blue-peacock-feather-674010/");
        userServices.saveUser(user);




        //fetch
        //validate
        //save to db
        //message
       Message message= Message.builder().content("registeration sucessfull").type(MessageType.green).build();
      session.setAttribute("message", message);

        return "redirect:/signup";
    }
}

