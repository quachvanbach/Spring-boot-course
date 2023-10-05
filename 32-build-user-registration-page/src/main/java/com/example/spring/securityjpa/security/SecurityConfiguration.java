package com.example.spring.securityjpa.security;

import com.example.spring.securityjpa.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers("/register/**").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                form -> form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/")
                        .permitAll()
        ).logout(
                logout -> logout.permitAll()
                        .logoutSuccessUrl("/showLoginPage")
        ).exceptionHandling(
                configurer -> configurer.accessDeniedPage("/showPage403")
        );

        return httpSecurity.build();
    }
}
