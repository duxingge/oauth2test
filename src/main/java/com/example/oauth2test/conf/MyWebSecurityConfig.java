package com.example.oauth2test.conf;

import com.example.oauth2test.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Bean
   MyUserDetailService userDetailService(){
       return new MyUserDetailService();
   }



    @Bean
    AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth")
                .authorizeRequests()
                .antMatchers("/oauth")
                .permitAll();
    }
}
