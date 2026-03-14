package com.example.mathwarapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MathWarAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MathWarAppApplication.class, args);
    }
}
