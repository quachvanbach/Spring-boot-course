package com.example.spring.studentmanagesystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfiguration {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails teacher = User.withUsername("teacher").password("{noop}password").roles("teacher").build();
        UserDetails manager = User.withUsername("manager").password("{noop}password").roles("manager").build();
        UserDetails student = User.withUsername("student").password("{noop}password").roles("student").build();

        return new InMemoryUserDetailsManager(teacher, manager, student);
    }
}
