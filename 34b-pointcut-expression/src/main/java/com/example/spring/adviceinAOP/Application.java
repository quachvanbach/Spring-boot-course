package com.example.spring.adviceinAOP;

import com.example.spring.adviceinAOP.service.CalculatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(CalculatorService calculator) {
        return commandLineRunner -> {
            // Before & AfterReturning
            double resultAdd = calculator.add(413243324, 343234234);

            double resultMultiple = calculator.multiply(2*(4*(12+(14))),4*(123+(12)));

            double resultDivide = calculator.multiply(334435234,435);

        };
    }

}
