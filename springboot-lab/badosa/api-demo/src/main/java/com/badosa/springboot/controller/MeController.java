package com.badosa.springboot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/me")
public class MeController {

    private Map<String, Object> profile = new HashMap<>();

    public MeController() {
        profile.put("name", "Bien Manuel P. Badosa");
        profile.put("studentId", "2025-1021747");
        profile.put("course", "Java Programming");
        profile.put("message", "Learning Spring Boot REST APIs!");
    }

    // Get - returns the profile information
    @GetMapping
    public Map<String, Object> getMe() {
        return profile;
    }

    // Post - adds new fields to the profile
    @PostMapping
    public Map<String, Object> createField(@RequestBody Map<String, Object> newData) {
        profile.putAll(newData);
        return profile;
    }

    // Put - updates existing fields in the profile
    @PutMapping
    public Map<String, Object> updateField(@RequestBody Map<String, Object> updatedData) {
        profile.putAll(updatedData);
        return profile;
    }

    // Delete - removes a field from the profile
    @DeleteMapping("/{key}")
    public Map<String, Object> deleteField(@PathVariable String key) {
        profile.remove(key);
        return profile;
    }
}
/*
 * 1. How did you create your Spring Boot project?
 * - I used Spring Initializr to create a new Spring Boot project with the
 * necessary dependencies.
 * 2. What is the purpose of the @RestController annotation?
 * - The @RestController annotation is used to create RESTful web services. It
 * combines @Controller and @ResponseBody, allowing us to return data directly
 * from the controller methods.
 * 3. What does the @GetMapping("/me") annotation do?
 * - The @GetMapping("/me") annotation maps HTTP GET requests to the getMe()
 * method, allowing clients to retrieve the profile information when they access
 * the /me endpoint.
 * 4. Why did you change from returning a String to a Map?
 * - I changed from returning a String to a Map to provide more structured and
 * detailed information about the profile. A Map allows us to include multiple
 * key-value pairs, making it easier to represent complex data.
 * 5. How does Spring Boot handle JSON responses automatically?
 * - Spring Boot uses the Jackson library to automatically convert Java objects
 * (like Maps) into JSON format when returning responses from controller
 * methods. This allows clients to receive data in a widely accepted format
 * without needing additional configuration.
 */