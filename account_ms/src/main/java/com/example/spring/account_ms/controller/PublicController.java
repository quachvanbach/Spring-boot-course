package com.example.spring.account_ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class PublicController {
    @GetMapping("/home")
    public String showAdminPage(){
        return "index";
    }
}
