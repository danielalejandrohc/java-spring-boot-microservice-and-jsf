package com.danielalejandrohc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HttpRestSecurity extends WebSecurityConfigurerAdapter {
    private final String ADMIN_ROLE = "admin";
    private final String USER_STORES_ENDPOINT  = "userStores";
    private final String MOVIES_ENDPOINT = "movies";

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/" + MOVIES_ENDPOINT + "/**").anonymous()
                .antMatchers(HttpMethod.POST, "/" + MOVIES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/" + MOVIES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PATCH, "/" + MOVIES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/" + MOVIES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/" + USER_STORES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/" + USER_STORES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/" + USER_STORES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PATCH, "/" + USER_STORES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/" + USER_STORES_ENDPOINT + "/**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
