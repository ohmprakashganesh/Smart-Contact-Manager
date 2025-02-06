package com.scm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.scm.Services.SecurityCustomUserDetailsService;


import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    final private OauthAuthenticationSucessHandler oauthAuthenticationSucessHandler;

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

            authorize.requestMatchers("/user/**")
            .authenticated()
            .anyRequest()
            .permitAll();
        });

        //if we need the spring login form then use this defaults
        // httpSecurity.formLogin(Customizer.withDefaults());
        // return httpSecurity.build();


        //for custom login page 
        httpSecurity.formLogin(form->{
            form.loginPage("/login")
            .loginProcessingUrl("/authenticate")
            .successForwardUrl("/user/profile")
            .failureUrl("/login?error=true")
            .usernameParameter("email")
            .passwordParameter("password");
            // .failureHandler(new AuthenticationFailureHandler() {

            //     @Override
            //     public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            //             AuthenticationException exception) throws IOException, ServletException {
            //         // TODO Auto-generated method stub
            //         throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationFailure'");
            //     }
                
            // })
            // .successHandler(new AuthenticationSuccessHandler() {

            //     @Override
            //     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            //             Authentication authentication) throws IOException, ServletException {
            //         // TODO Auto-generated method stub
            //         throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationSuccess'");
            //     }
                
            // });

        });
       //disable it so we can add own logout url
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
        .logout(out->{
            out.logoutUrl("/out")
                .logoutSuccessUrl("/login?logout=true");
        });

        //Oauth2 configuration

        //if we need default of only oauth 2 
        // httpSecurity.oauth2Login(Customizer.withDefaults());

        httpSecurity.oauth2Login(oauth->{
            oauth.loginPage("/login")
            .successHandler(oauthAuthenticationSucessHandler);

           
        });
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
