package com.example.spring.account_ms.service;

import com.example.spring.account_ms.entity.ManagedAccount;
import com.example.spring.account_ms.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> getAll();
    public List<ManagedAccount> getAccountsByUsername(String username);

    public User getByUsername(String username);

    public void save(User user);

    public void update(User user);

    public void deleteById(long id);
}
