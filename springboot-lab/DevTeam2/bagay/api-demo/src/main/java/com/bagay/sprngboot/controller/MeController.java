package com.bagay.sprngboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for the /me endpoint
 *
 * How did you create your Spring Boot project?
 * - I used Spring Initializr (start.spring.io) to generate a Maven project with Spring Boot 4.0.6
 * - Selected Java language, added Spring Web dependency
 * - Configured group ID as com.bagay.sprngboot and artifact as api-demo
 *
 * What is the purpose of the @RestController annotation?
 * - @RestController is a Spring annotation that combines @Controller and @ResponseBody
 * - It marks the class as a controller where methods return JSON/data directly (not view names)
 * - Every method automatically serializes the response to JSON format
 *
 * What does the @GetMapping("/me") annotation do?
 * - @GetMapping("/me") maps HTTP GET requests to the /me endpoint to this method
 * - It creates a route that listens for GET requests at http://localhost:8080/me
 *
 * Why did you change from returning a String to a Map?
 * - Returning a Map allows us to provide structured, key-value data as JSON
 * - It's more flexible and professional for APIs - clients can access specific fields like "name", "studentId"
 * - JSON responses are more commonly used in REST APIs than plain text
 *
 * How does Spring Boot handle JSON responses automatically?
 * - Spring Boot automatically uses Jackson library to serialize Java objects to JSON
 * - When a method returns a Map or object annotated with @RestController, Spring converts it to JSON
 * - The @ResponseBody annotation (inherited from @RestController) tells Spring to serialize the return value
 * - The Content-Type header is automatically set to application/json
 */
@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Axe Drake M. Bagay");
        response.put("studentId", "2025-1020735");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

