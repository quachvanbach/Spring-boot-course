package com.example.spring.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String index(){
        return "Hello world!";
    }

    @GetMapping("/h2")
    public String index1(){
        return "Xin chào!";
    }
}
