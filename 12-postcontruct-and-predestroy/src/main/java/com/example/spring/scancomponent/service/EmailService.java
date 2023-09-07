package com.example.spring.scancomponent.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    @PostConstruct
    public void init() {
        System.out.println("Đoạn code này được run ngay khi tạo: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroyIt() {
        System.out.println("Đoạn code này được run trước khi huỷ bỏ " + getClass().getSimpleName());
    }

    public EmailService() {
        System.out.println("Constructor of class: " + getClass().getSimpleName());
    }

    @Override
    public String sendMasage() {
        return "Email sending............";
    }
}
