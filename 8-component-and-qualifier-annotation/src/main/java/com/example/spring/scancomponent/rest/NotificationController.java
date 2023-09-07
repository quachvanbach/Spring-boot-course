package com.example.spring.scancomponent.rest;

import com.example.spring.scancomponent.service.EmailService;
import com.example.spring.scancomponent.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class NotificationController {
    private MessageService service;

    @Autowired
    public NotificationController(@Qualifier("emailService") MessageService service) {
        this.service = service;
    }

    @GetMapping("/send-message")
    public String sendEmail() {
        return this.service.sendMasage();
    }
}
