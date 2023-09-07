package com.example.spring.scancomponent.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Override
    public String sendMasage() {
        return "Sms sending..............";
    }
}
