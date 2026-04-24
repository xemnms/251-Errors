package com.bautista.springboot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private Map<String, String> student = new HashMap<>();

    @GetMapping
    public Map<String, String> getStudent() {
        return student;
    }

    @PostMapping
    public String createStudent(@RequestParam String name) {
        student.put("name", name);
        return "Created: " + name;
    }

    @PutMapping
    public String updateStudent(@RequestParam String name) {
        student.put("name", name);
        return "Updated: " + name;
    }

    @DeleteMapping
    public String deleteStudent() {
        student.clear();
        return "Deleted Student Info";
    }
}