package com.example.spring.adviceinAOP.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b){
        System.out.println("Result of add method: " + (a+b));
        return a+b;
    }

    public double substract(double a, double b){
        System.out.println("Result of add method: " + (a-b));
        return a-b;
    }

    public double multiply(double a, double b){
        System.out.println("Result of add method: " + (a*b));
        return a*b;
    }

    public double divide(){
        double a=6;
        double b=Double.parseDouble("three");
        System.out.println("Result of add method: " + (a/b));
        return a/b;
    }


}
