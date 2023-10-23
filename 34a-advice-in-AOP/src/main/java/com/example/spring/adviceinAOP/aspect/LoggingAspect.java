package com.example.spring.adviceinAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution (* com.example.spring.adviceinAOP.service.CalculatorService.*(..))")
    public void beforeCalculate(JoinPoint joinPoint){
        System.out.println("Running method add of the calculator");
    }

    @AfterReturning("execution (* com.example.spring.adviceinAOP.service.CalculatorService.*(..))")
    public void afterSuccessfulCalculate(JoinPoint joinPoint){
        System.out.println("Done!");
    }

    @AfterThrowing("execution (* com.example.spring.adviceinAOP.service.CalculatorService.*(..))")
    public void afterCalculateFailed(JoinPoint joinPoint){
        System.out.println("Error....!");
    }
}
