package com.example.spring.studentmanagesystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {

    // Tuỳ chỉnh cấu hình bảng user
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT id, pwd, active FROM accounts WHERE id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM roles WHERE id=?");
        return userDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails admin = User.withUsername("admin").password("{noop}password").roles("ADMIN").build();
//        UserDetails manager = User.withUsername("manager").password("{noop}password").roles("MANAGER").build();
//        UserDetails user = User.withUsername("user").password("{noop}password").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin, manager, user);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("ADMIN", "MANAGER", "USER")
                .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("ADMIN", "MANAGER", "USER")
                .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("ADMIN"));
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
