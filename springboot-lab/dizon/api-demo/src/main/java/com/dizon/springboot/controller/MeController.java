package com.dizon.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    /*
     * Task 10: Code-Based Analysis
     * 1. Project Creation: Used Spring Initializr (start.spring.io) with Maven, Java 17, and Spring Web.
     * 2. @RestController: Tells Spring this class handles web requests and returns data (JSON) directly to the body.
     * 3. @GetMapping("/me"): Specifically maps HTTP GET requests on the "/me" path to this method.
     * 4. Why a Map?: Using a Map<String, Object> allows us to return multiple key-value pairs which Spring formats as JSON.
     * 5. JSON Handling: Spring Boot uses the Jackson library to automatically convert Java objects/maps into JSON format.
     */

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Andrew Dizon");
        response.put("studentId", "2025-1024539");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}