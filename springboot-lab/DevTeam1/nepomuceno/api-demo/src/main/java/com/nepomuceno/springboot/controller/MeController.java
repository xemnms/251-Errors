package com.nepomuceno.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Julliana P. Nepomuceno");
        response.put("studentId", "2024-2020430");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

/**
 * REST Controller for the /me endpoint
 *
 * How did you create your Spring Boot project?
 * - The project was created using Spring Initializr (start.spring.io) as a Maven-based Spring Boot application
 * - Java was selected as the language, and the Spring Web dependency was added
 * - The group ID was set to com.bagay.springboot and the artifact ID to api-demo
 *
 * What is the purpose of the @RestController annotation?
 * - @RestController combines @Controller and @ResponseBody
 * - It designates the class as a REST controller that returns data directly instead of rendering views
 * - The returned data is automatically converted into JSON format
 *
 * What does the @GetMapping("/me") annotation do?
 * - @GetMapping("/me") maps HTTP GET requests to the /me endpoint
 * - It defines a route that listens at http://localhost:8080/me
 *
 * Why did you change from returning a String to a Map?
 * - Returning a Map allows data to be structured as key-value pairs in JSON
 * - It provides more flexibility and is better suited for API responses
 * - JSON is the standard format used in RESTful services
 *
 * How does Spring Boot handle JSON responses automatically?
 * - Spring Boot uses the Jackson library to convert Java objects into JSON
 * - When a method in a @RestController returns a Map or object, it is automatically serialized
 * - The response is sent with the Content-Type set to application/json
 */