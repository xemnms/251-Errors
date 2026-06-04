package com.app.batangan.controller;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// GRASP: Controller - handles HTTP only, no business logic
// GRASP: Low Coupling - depends on TaskService interface
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // GRASP: Low Coupling - injected via interface, not TaskServiceImpl
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST /api/tasks  → create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto) {
        Task created = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /api/tasks  → get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET /api/tasks/1  → get one task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // PUT /api/tasks/1/status?status=DONE  → update status
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    // GET /api/tasks/filter?status=PENDING  → filter by status
    @GetMapping("/filter")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    // DELETE /api/tasks/1  → delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}