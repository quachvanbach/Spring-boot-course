package com.example.spring.scancomponent.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {

    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
