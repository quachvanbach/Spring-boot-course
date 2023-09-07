package com.example.spring.scancomponent.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    public SmsService() {
        System.out.println("Constructor of class: " + getClass().getSimpleName());
    }
    @Override
    public String sendMasage() {
        return "Sms sending..............";
    }
}
