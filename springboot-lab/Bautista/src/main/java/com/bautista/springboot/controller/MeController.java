package com.bautista.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {

        Map<String, Object> response = new HashMap<>();

        response.put("name", "Lei Bautista");
        response.put("studentId", "2025-1028356");
        response.put("course", "Object-Oriented Programming");
        response.put("message", "Learning Spring Boot REST APIs!");

        return response;
    }
}

/* ====== CODE-BASED ANALYSIS ======

1. How did you create your Spring Boot project?
   I created my Spring Boot project using Spring Initializr (start.spring.io).
   I selected Maven as the build tool, Java as the language, and added Spring Web as the dependency.
   After generating the project, I imported it into IntelliJ IDEA.

2. What is the purpose of the @RestController annotation?
   @RestController is used to define a class as a REST API controller.
   It allows the class to return data directly in JSON or text format instead of rendering a webpage.

3. What does the @GetMapping("/me") annotation do?
   @GetMapping("/me") maps HTTP GET requests to the "/me" endpoint.
   When this endpoint is accessed, the method is executed and returns the response data.

4. Why did you change from returning a String to a Map?
   I used a Map for returning data because it allows me to return structured information in JSON format.
   This is useful when handling multiple key-value pairs such as student details.
   In the StudentController, I used String responses for simple confirmation messages for operations like create, update, and delete.

5. How does Spring Boot handle JSON responses automatically?
   Spring Boot automatically converts Java objects into JSON format using the Jackson library when using @RestController.

*/