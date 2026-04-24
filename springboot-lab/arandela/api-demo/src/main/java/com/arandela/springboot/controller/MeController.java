package com.arandela.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for the /me endpoint
 *
 * How did you set up your Spring Boot project?
 * - I used Spring Initializr (start.spring.io) to generate a Maven project with Spring Boot 4.0.6
 * - Chose Java as the language and added the Spring Web dependency
 * - Defined group ID as com.bagay.sprngboot and artifact as api-demo
 *
 * What is the role of the @RestController annotation?
 * - @RestController is a Spring annotation that merges @Controller and @ResponseBody
 * - It designates the class as a controller where methods return JSON/data directly instead of view names
 * - Each method’s output is automatically serialized into JSON format
 *
 * What does the @GetMapping("/me") annotation accomplish?
 * - @GetMapping("/me") binds HTTP GET requests for the /me endpoint to this method
 * - It establishes a route that listens for GET requests at http://localhost:8080/me
 *
 * Why switch from returning a String to a Map?
 * - Returning a Map enables structured, key-value data to be sent as JSON
 * - It’s more versatile and professional for APIs, allowing clients to access fields like "name" or "studentId"
 * - JSON responses are the standard in REST APIs compared to plain text
 *
 * How does Spring Boot automatically manage JSON responses?
 * - Spring Boot leverages the Jackson library to convert Java objects into JSON
 * - When a method returns a Map or object within a @RestController, Spring serializes it into JSON
 * - The @ResponseBody annotation (inherited from @RestController) directs Spring to serialize the return value
 * - The Content-Type header is automatically set to application/json
 */

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Jherrymei D. Arandela");
        response.put("studentId", "2025-1029981");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}
