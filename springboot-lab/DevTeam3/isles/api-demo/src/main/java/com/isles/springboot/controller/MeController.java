package com.isles.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Dan Marvin M. Isles");
        response.put("studentId", "2025-1025621");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }

    //CODE-BASED ANALYSIS
    /*
    1. How did you create your Spring Boot project?
    -I created the project using Spring Initializr, selecting Maven/Gradle,
    Java version, and adding the Spring Web dependency.

    2. What is the purpose of the @RestController annotation?
    -It marks the class as a REST API controller where methods return data instead of views.
     It combines @Controller and @ResponseBody.

    3. What does the @GetMapping("/me") annotation do?
    -It maps HTTP GET requests to the "/me" endpoint and runs the method when accessed.

    4. Why did you change from returning a String to a Map?
    -To return structured JSON data (key-value pairs) instead of plain text,
     making it easier for API responses to be read and used.

    5. How does Spring Boot handle JSON responses automatically?
    -Spring Boot uses Jackson (built-in) to automatically convert Java objects like Maps or POJOs
      into JSON when returned from a REST controller.
    */
}