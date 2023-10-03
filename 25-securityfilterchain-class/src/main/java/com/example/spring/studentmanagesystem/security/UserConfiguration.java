package com.example.spring.studentmanagesystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User.withUsername("admin").password("{noop}password").roles("admin").build();
        UserDetails manager = User.withUsername("manager").password("{noop}password").roles("manager").build();
        UserDetails user = User.withUsername("user").password("{noop}password").roles("user").build();

        return new InMemoryUserDetailsManager(admin, manager, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("admin", "manager", "user")
                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("admin", "manager", "user")
                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("admin", "manager")
                        .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("admin", "manager")
                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("manager")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
