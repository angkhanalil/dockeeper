/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author 92610
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) 
//            throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0}")
//                .groupSearchBase("ou=user")
                .contextSource()
                .url("ldap://10.11.9.135:389/dc=wacoal,dc=co,dc=th");
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new LdapShaPasswordEncoder())
//                  .passwordEncoder(new Md5PasswordEncoder())
//                .passwordAttribute("userPassword");
    }
}
