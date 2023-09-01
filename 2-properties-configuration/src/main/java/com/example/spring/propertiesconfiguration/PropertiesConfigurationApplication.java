package com.example.spring.propertiesconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertiesConfigurationApplication {
    @Value("${khoahoc.ten}")
    private String ten;
    @Value("${khoahoc.gia}")
    private String gia;

    public static void main(String[] args) {
        SpringApplication.run(PropertiesConfigurationApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Cấu hình file application.properties";
    }

    @GetMapping("/khoahoc")
    public String khoahoc() {
        return "Tên khoá học: " + ten
                + "</br> Giá: " + gia;
    }
}
