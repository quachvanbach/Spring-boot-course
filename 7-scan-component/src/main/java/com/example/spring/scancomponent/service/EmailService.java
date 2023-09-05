package com.example.spring.scancomponent.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface{

    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
