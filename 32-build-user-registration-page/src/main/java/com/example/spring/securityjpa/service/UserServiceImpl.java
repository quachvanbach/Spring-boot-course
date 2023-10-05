package com.example.spring.securityjpa.service;

import com.example.spring.securityjpa.dao.RoleRepository;
import com.example.spring.securityjpa.dao.UserRepository;
import com.example.spring.securityjpa.entity.Role;
import com.example.spring.securityjpa.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

//    @PostConstruct
//    public void insertUser() {
//        User user1 = new User();
//        user1.setUsername("bachqv");
//        user1.setPassword("");
//        user1.setEnable(true);
//        userRepository.save(user1);
//
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//
//        Collection<Role> roles = new ArrayList<>();
//        roles.add(role1);
//
//        user1.setRoles(roles);
//
//        userRepository.save(user1);
//    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("In valid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
    userRepository.save(user);
    }
}
