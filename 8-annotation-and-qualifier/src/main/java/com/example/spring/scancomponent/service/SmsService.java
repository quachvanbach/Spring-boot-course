package com.example.spring.scancomponent.service;

public class SmsService implements MessageService{
    @Override
    public String sendMasage() {
        return "Sms sending..............";
    }
}
