package com.rodenas.springboot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/me")
public class MeController {

    private Map<String, Object> profile = new HashMap<>();

    public MeController() {
        profile.put("name", "Kyla Cassandra R. Rodenas");
        profile.put("studentId", "2025-1025868");
        profile.put("course", "Java Programming");
        profile.put("message", "Learning Spring Boot REST APIs!");
    }

    // GET - retrieve profile
    @GetMapping
    public Map<String, Object> getMe() {
        return profile;
    }

    // POST - create/add a new field to profile
    @PostMapping
    public Map<String, Object> createField(@RequestBody Map<String, Object> newData) {
        profile.putAll(newData);
        return profile;
    }

    // PUT - update an existing field in profile
    @PutMapping
    public Map<String, Object> updateField(@RequestBody Map<String, Object> updatedData) {
        profile.putAll(updatedData);
        return profile;
    }

    // DELETE - remove a field from profile by key
    @DeleteMapping("/{key}")
    public Map<String, Object> deleteField(@PathVariable String key) {
        profile.remove(key);
        return profile;
    }
}

/* ====== CODE-BASED ANALYSIS ======

1. How did you create your Spring Boot project?
   I created my Spring Boot project using Spring Initializr (start.spring.io).
   I configured the project metadata such as group, artifact, name, and package name,
   selected Maven as the build tool, Java as the language, and added the Spring Web
   dependency. Then I downloaded and extracted the ZIP file into my project folder.

2. What is the purpose of the @RestController annotation?
   @RestController marks this class as a REST controller in Spring Boot.
   It combines @Controller and @ResponseBody, meaning every method in this class
   returns data like JSON or plain text directly to the HTTP response
   instead of rendering an HTML view or page.

3. What does the @GetMapping("/me") annotation do?
   @GetMapping("/me") maps HTTP GET requests sent to the "/me" URL to the getMe() method.
   So when someone visits http://localhost:8080/me, Spring Boot automatically
   calls this method and returns its result to the client.

4. Why did you change from returning a String to a Map?
   I changed from returning a String to a Map so the response can hold multiple fields
   like name, studentId, course, and message. A Map allows us to structure
   the data better and return more meaningful information in a single response.

5. How does Spring Boot handle JSON responses automatically?
   Spring Boot uses a built-in library called Jackson to automatically convert
   Java objects like Map into JSON format. When a method in a @RestController
   returns an object, Jackson serializes it into JSON without requiring
   any extra configuration or setup from the developer.

*/