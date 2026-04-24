package com.arandela.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * MeController - REST API endpoint for student information
 *
 * How did you create your Spring Boot project?
 * - Used Spring Initializr (start.spring.io) with Maven as the build tool
 * - Added Spring Web dependency for REST capabilities
 * - Configured with Java 17 and Spring Boot 4.0.6
 *
 * What is the purpose of the @RestController annotation?
 * - Marks the class as a REST controller
 * - Automatically serializes return values to JSON
 * - Combines @Controller and @ResponseBody annotations
 *
 * What does the @GetMapping("/me") annotation do?
 * - Maps HTTP GET requests to the /me endpoint
 * - Allows clients to retrieve student information via GET /me
 *
 * Why did you change from returning a String to a Map?
 * - JSON responses are more structured and contain more meaningful data
 * - Makes the API more production-ready and extensible
 * - Easier for clients to parse and work with multiple data fields
 *
 * How does Spring Boot handle JSON responses automatically?
 * - Spring uses Jackson library for automatic JSON serialization
 * - The @RestController annotation enables automatic HttpMessageConverter
 * - Map objects are automatically converted to JSON format
 */
@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Arandela, Student");
        response.put("studentId", "Unknown");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

