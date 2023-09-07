package com.example.spring.scancomponent.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Cấu hình trực tiếp tại class.
public class ZaloService implements MessageService {
    public ZaloService() {
        System.out.println("Constructor of class: " + getClass().getSimpleName());
    }

    @Override
    public String sendMasage() {
        return "Zalo sending..........";
    }
}
