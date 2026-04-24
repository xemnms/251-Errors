package com.galindon.springboot.api_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Lynette Grace Galindon");
        response.put("studentId", "2025-2022743");
        response.put("course", "BS Computer Science");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}