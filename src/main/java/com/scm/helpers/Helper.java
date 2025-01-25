package com.scm.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;


public class Helper {
    public static String getEmailOfLoggedUser(Authentication authentication){

    String username= "";
    //if  logged with email and password 


    if(authentication instanceof OAuth2AuthenticationToken){
          var oAuth2AuthenticationToken=(OAuth2AuthenticationToken) authentication;
          var clientId= oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

          var oauth2user= (OAuth2User)authentication.getPrincipal();

          if(clientId.equalsIgnoreCase("google")){
            System.out.println("getting email from google");
            System.out.println(oauth2user.getAttribute("email").toString());
          }
           if(clientId.equalsIgnoreCase("github")){
            System.out.println("Getting email from github");
            username = oauth2user.getAttribute("email") != null ? oauth2user.getAttribute("email").toString()
                    : oauth2user.getAttribute("login").toString() + "@gmail.com";
          }
          if(clientId.equalsIgnoreCase("facebook")){
            System.out.println("getting name form facebook ");
            System.out.println(oauth2user.getAttribute("email").toString());


          }else{
            username =  authentication.getName();
            
          }
        
            //sign with google
    }  
    return  username ;
    }

}
