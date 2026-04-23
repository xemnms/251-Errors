package com.dizon.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/*
 * CODE-BASED ANALYSIS (Lab Task 10)
 *
 * Q: How did you create your Spring Boot project?
 * A: I used Spring Initializr (start.spring.io) to generate a Maven project.
 *    I selected Java, Spring Boot 3.2.x, set the group as com.dizon.springboot,
 *    artifact as api-demo, and added the Spring Web dependency. I then downloaded
 *    the ZIP and extracted it into my dizon/ folder inside the team repository.
 *
 * Q: What is the purpose of the @RestController annotation?
 * A: As the guide explains, @RestController combines @Controller and @ResponseBody.
 *    It marks this class as a REST API controller where every method's return value
 *    is written directly into the HTTP response body. This means Spring does not
 *    look for a view (like an HTML page) — it just returns the data as-is.
 *
 * Q: What does the @GetMapping("/me") annotation do?
 * A: It maps HTTP GET requests sent to the "/me" path to the getMe() method.
 *    Based on the guide's REST controller examples, when a client sends
 *    GET http://localhost:8080/me, Spring automatically routes it to this method
 *    and returns its result as the HTTP response.
 *
 * Q: Why did you change from returning a String to a Map?
 * A: Returning a Map allows us to send structured data with multiple fields
 *    (name, studentId, course, message) instead of a plain text sentence.
 *    The guide demonstrates this pattern with the UserController — using objects
 *    and maps makes responses more useful, machine-readable, and closer to
 *    how real-world REST APIs work.
 *
 * Q: How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot includes the Jackson library via spring-boot-starter-web.
 *    As the guide explains, when a @RestController method returns a Map or
 *    any Java object, Jackson automatically serializes it into a JSON string
 *    and sets the Content-Type header to "application/json" — no extra
 *    configuration is needed.
 */

// @RestController - marks this as a REST API controller
// Learned from the guide's Dependency Injection and REST Controllers sections
@RestController
public class MeController {

    // @GetMapping maps HTTP GET /me requests to this method
    // This follows the same pattern shown in the guide's GreetingController example
    @GetMapping("/me")
    public Map<String, Object> getMe() {

        // Using HashMap to build a structured response
        // Spring Boot + Jackson will automatically convert this to JSON
        // This pattern is taken from the guide's REST Controllers section
        Map<String, Object> response = new HashMap<>();

        response.put("name", "Andrew Dizon");
        response.put("studentId", "2025-1024539");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");

        return response;
    }
}