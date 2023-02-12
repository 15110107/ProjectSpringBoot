package com.example.hometest.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class BasicAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                                .authorizeRequests()
                                .antMatchers("/").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .logout()
                                .permitAll();
        }

        @Autowired
        public void registerGlobalAuthentication(
                        AuthenticationManagerBuilder auth) throws Exception {
                auth
                                .inMemoryAuthentication()
                                .withUser("admin").password("123456").roles("ADMIN");
        }
}
