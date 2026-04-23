package com.bagay.springboot.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    // Created with Spring Initializr and then extended manually for the lab endpoint requirements.
    // @RestController marks this class as a web controller where return values are written to the HTTP response body.
    // @GetMapping("/me") maps HTTP GET requests for /me to this method.
    // Returning Map lets Spring serialize structured JSON instead of a single plain text String.
    // Spring Boot automatically converts this Map to JSON through Jackson in the web starter.
    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Axel Drake M. Bagay");
        response.put("studentId", "2025-1020735");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

