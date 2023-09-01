package com.example.spring.autorebuildapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/")
    public String index(){
        return "Hello. Auto rebuild is ready";
    }
}
