package com.example.spring.scancomponent.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageService{
    @Override
    public String sendMasage() {
        return "Zalo sending..........";
    }
}
