package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.Services.SecurityCustomUserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    final private SecurityCustomUserDetailsService securityCustomUserDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        //user detail service ka object
        daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
        //password encorder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //configuration 
        httpSecurity.authorizeHttpRequests(authorize-> {
            // authorize.requestMatchers("/home","/signup", "/login","/service").permitAll();

            authorize.requestMatchers("/user/**").authenticated().anyRequest().permitAll();
        });
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();


    }
























//user creaate and login using java code with in memory 
// @Bean
//This is hard corded login 
// public UserDetailsService userDetailsService(){
//    UserDetails user1=  User
//    .withDefaultPasswordEncoder()
//    .username("om")
//    .password("123")
//    .roles("user","admin")
//    .build();
//     return new InMemoryUserDetailsManager(user1);
// }


//@Bean



    
}
