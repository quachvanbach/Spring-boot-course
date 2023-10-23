package com.example.spring.account_ms.service;

import com.example.spring.account_ms.dao.RoleRepository;
import com.example.spring.account_ms.dao.UserRepository;
import com.example.spring.account_ms.entity.ManagedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring.account_ms.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<ManagedAccount> getAccountsByUsername(String username) {
        return userRepository.getAccountByUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("In valid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(String.valueOf(user.getRole().getRole()))));
    }
}
