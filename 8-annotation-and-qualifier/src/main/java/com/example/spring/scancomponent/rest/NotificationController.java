package com.example.spring.scancomponent.rest;

import com.example.spring.scancomponent.service.EmailService;
import com.example.spring.scancomponent.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageService email;

    @Autowired
    public NotificationController(EmailService email) {
        this.email = email;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        return this.email.sendMasage();
    }
}
