package com.mscharhag.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Collections;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class
})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Define two users: John and Anna
        auth.inMemoryAuthentication()
            .withUser("John").password("{noop}password").roles()
        .and()
            .withUser("Anna").password("{noop}password").roles();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // enable http basic auth
            .httpBasic()
        .and()
            .authorizeRequests()
            .antMatchers("/**").fullyAuthenticated()
        .and()
            .csrf().disable()
            .formLogin().disable();
    }
}
