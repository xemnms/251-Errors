package com.alvarez.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me") 
        public Map<String, Object> getMe() {
            Map<String, Object> response = new HashMap<>();
            response.put("name", "Angelo Hayden Alvarez");
            response.put("studentId", "<2025-1026476");
            response.put("course", "Java Programming");
            response.put("message", "Learning Spring Boot REST APIs!");
            return response;
        }
    }

