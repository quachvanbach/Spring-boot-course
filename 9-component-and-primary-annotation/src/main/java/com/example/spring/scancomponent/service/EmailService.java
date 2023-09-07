package com.example.spring.scancomponent.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailService implements MessageService {

    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
