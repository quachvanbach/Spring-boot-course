package com.example.spring.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface{

    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
