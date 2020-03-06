/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielalejandrohc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author daniel
 */
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final String ADMIN_ROLE = "admin";
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/" + "**" ).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/" + "**" ).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/" + "**" ).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PATCH, "/" + "**" ).hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/" + "**" ).hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable();
    }
}
