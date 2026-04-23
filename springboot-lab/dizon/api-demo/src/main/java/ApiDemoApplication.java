package com.dizon.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication combines @Configuration, @EnableAutoConfiguration,
// and @ComponentScan — it bootstraps the entire Spring Boot application.
// As the guide explains, this starts the embedded Tomcat server automatically.
@SpringBootApplication
public class ApiDemoApplication {

    public static void main(String[] args) {
        // Starts the embedded server and initializes the Spring context
        SpringApplication.run(ApiDemoApplication.class, args);
    }
}