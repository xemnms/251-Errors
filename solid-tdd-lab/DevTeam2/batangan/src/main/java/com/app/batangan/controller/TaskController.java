package com.app.batangan.controller;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// SOLID: SRP - handles HTTP requests only, zero business logic
// SOLID: DIP - depends on TaskService interface, not TaskServiceImpl
// GRASP: Controller - already well-designed, no major changes needed
// NOTE: Good design already present — Low Coupling via interface injection
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(taskService.createTask(dto));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}