package com.example.spring.studentmanagesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Không thay đổi code. Truy cập https://bcrypt-generator.com/ để mã hoá mật khẩu và thay đổi lại mật khẩu trong database.

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
