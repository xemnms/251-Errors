package com.alonde.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceTest {

    public String getGreeting() {
        return "Hello, Spring Boot!";
    }
}