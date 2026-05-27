package com.fullstack_lab.rodenas.controller;

import com.fullstack_lab.rodenas.dto.StudentDTO;
import com.fullstack_lab.rodenas.model.Student;
import com.fullstack_lab.rodenas.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO dto) {
        Student student = new Student(dto.getName(), dto.getEmail(), dto.getCourse());
        return ResponseEntity.ok(service.createStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        Student student = new Student(dto.getName(), dto.getEmail(), dto.getCourse());
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}