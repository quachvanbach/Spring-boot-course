package com.example.spring.securityjpa.service;

import com.example.spring.securityjpa.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
}
