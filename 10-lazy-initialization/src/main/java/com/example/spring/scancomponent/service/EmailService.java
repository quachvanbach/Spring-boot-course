package com.example.spring.scancomponent.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class EmailService implements MessageService {

    public EmailService() {
        System.out.println("Constructor of class: " + getClass().getSimpleName());
    }
    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
