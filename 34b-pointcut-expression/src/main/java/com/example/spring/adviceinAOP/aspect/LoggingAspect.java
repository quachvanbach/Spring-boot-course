package com.example.spring.adviceinAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.example.spring.adviceinAOP.service.*.*(..))")
    public void myPointCut() {

    }

    @Before("myPointCut()")
    public void beforeExecutedMethod(JoinPoint joinPoint) {
        System.out.println("Running " + joinPoint.getSignature().getName() + ": ");
    }

    @Around("myPointCut()")
    public Object measureExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println("Result of " + methodName + ": " + result);
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Execution time: " + executionTime);
        System.out.println("----------------------------------------");
        return result;
    }

    @After("myPointCut()")
    public void afterExecutedMethod(JoinPoint joinPoint) {
        System.out.println("Done " + joinPoint.getSignature().getName() + ": ");
    }

}
