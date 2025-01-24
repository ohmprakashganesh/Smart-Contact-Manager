package com.scm.config;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.Repositories.UserRepository;
import com.scm.entities.User;
import com.scm.helpers.AppConstants;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class OauthAuthenticationSucessHandler implements AuthenticationSuccessHandler {

Logger logger= LoggerFactory.getLogger(OauthAuthenticationSucessHandler.class);

@Autowired
 private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
       
                logger.info("OAuthAuthenticationSuccessHandler ");

                var oauth2AuthenticationToken= (OAuth2AuthenticationToken)authentication;

                String authorizedClientRegistrationId= oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
                logger.info(authorizedClientRegistrationId);

                var user0= (DefaultOAuth2User)authentication.getPrincipal();
                user0.getAttributes().forEach((key,value)->{
                    logger.info(key+ " :" + value);
                });
                

                User user = new User();
                user.setRoles(List.of(AppConstants.ROLE_USER));
                user.setEmailVerified(true);
                user.setEnabled(true);



            if(authorizedClientRegistrationId.equalsIgnoreCase("google")){
            //write her google code 
            // user.setEmail(user0.getAttribute("email").toString());
            // user.setProfilePic(user0.getAttribute("picture").toString());
            // user.setName(user0.getAttribute("name").toString());
            // user.setProviderUserId(user0.getName());                

            }else if(authorizedClientRegistrationId.equalsIgnoreCase("github")){

                //github code 

                String email= user0.getAttribute("email") != null 
                ?user0.getAttribute("email").toString()
                :user0.getAttribute("login").toString()+"@gmail.com";
                String  picture= user0.getAttribute("avatar_url").toString();
                String name= user0.getAttribute("login").toString();
                String providerUserId= user0.getName();

                user.setEmail(email);
                user.setProfilePic(picture);
                user.setName(name);
                user.setProviderUserId(providerUserId);

            }else{
                logger.info("authorizedClientRegistrationId: unknown provider ");
            }



                //data to save in data base 

                // DefaultOAuth2User user= (DefaultOAuth2User)authentication.getPrincipal();
                // logger.info(user.getName());
                // user.getAttributes().forEach((key, value) -> {
                //     logger.info("() => {}", key, value);
                // });
                // logger.info(user.getAuthorities().toString());


                  User user2 = userRepository.findByEmail(user.getEmail()).orElse(null);
                  if(user2 == null){
                    userRepository.save(user);
                  }

                new DefaultRedirectStrategy().sendRedirect(request, response, "/user/profile");


    }

    
}
