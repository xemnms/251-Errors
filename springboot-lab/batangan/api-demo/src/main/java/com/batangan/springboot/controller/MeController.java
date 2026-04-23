package com.batangan.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    private Map<String, Object> profile = new HashMap<>();

    public MeController() {
        profile.put("name", "Clisha Rae V. Batangan");
        profile.put("studentId", "2025-1027945");
        profile.put("course", "Java Programming");
        profile.put("message", "Learning Spring Boot REST APIs!");
        
    }
 // GET endpoint that returns the current profile data
    @GetMapping
    public Map<String, Object> getMe() {
        return profile;
    }

    // POST endpoint that adds new fields to the profile
    @PostMapping
    public Map<String, Object> createField(@RequestBody Map<String, Object> newData) {
        profile.putAll(newData);
        return profile;
    }

    // PUT endpoint that updates existing fields or adds them if they don't exist
    @PutMapping
    public Map<String, Object> updateField(@RequestBody Map<String, Object> updatedData) {
        profile.putAll(updatedData);
        return profile;
    }

    // DELETE endpoint to removes a specific field from the profile using its key
    @DeleteMapping("/{key}")
    public Map<String, Object> deleteField(@PathVariable String key) {
        profile.remove(key);
        return profile;
    }
}