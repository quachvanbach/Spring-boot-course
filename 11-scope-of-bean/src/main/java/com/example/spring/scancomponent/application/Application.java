package com.example.spring.scancomponent.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication ( // Đối với các class cùng cấp hoặc class bên trong các package cùng cấp
		scanBasePackages = { // Đối với các class hoặc class bên trong các package không cùng thuộc thư mục chứa class
				"com.example.spring.scancomponent.application",
				"com.example.spring.scancomponent.rest",
				"com.example.spring.scancomponent.service"
		}
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
