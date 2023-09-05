package com.example.spring.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private MessageInterface email; // => Không nên sử dụng Field injection.

    @GetMapping("/send-email")
    public String sendEmail() {
        return this.email.sendMasage();
    }
}
