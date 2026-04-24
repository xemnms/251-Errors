package com.arandela.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

// How did you create your Spring Boot project?
// I created the Spring Boot project using Spring Initializr at start.spring.io, selecting Maven, Java, latest Spring Boot version, and adding Spring Web dependency.

@RestController
// What is the purpose of the @RestController annotation?
// The @RestController annotation marks this class as a REST controller, combining @Controller and @ResponseBody to handle web requests and return data directly.
public class MeController {

    @GetMapping("/me")
    // What does the @GetMapping("/me") annotation do?
    // The @GetMapping("/me") annotation maps HTTP GET requests to the "/me" endpoint to this method.
    // Why did you change from returning a String to a Map?
    // I changed to returning a Map to provide structured JSON data instead of plain text, allowing for better API responses with multiple fields.
    // How does Spring Boot handle JSON responses automatically?
    // Spring Boot automatically converts the returned Map to JSON using Jackson library included in Spring Web starter.
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Jherrymei Arandela");
        response.put("studentId", "JD");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

// Review and Retrospect:
// 1. Add more endpoints, like POST to update the information.
// 2. Add validation for the data.
// 3. Implement proper error handling with @ExceptionHandler.
// 4. Add logging for requests.
