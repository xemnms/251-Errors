package com.flowstate.controller;

import com.flowstate.dto.TaskRequest;
import com.flowstate.dto.TaskResponse;

import com.flowstate.service.TaskService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/tasks")

@RequiredArgsConstructor

@CrossOrigin(
    origins = {
        "http://localhost:5173",
        "https://ubiquitous-doodle-v64xj56g4xxvcw6xx-5173.app.github.dev"
    }
)

public class TaskController {

    private final
    TaskService taskService;

    @GetMapping
    public List<TaskResponse>
    getAllTasks() {

        return taskService
            .getAllTasks();
    }

    @PostMapping
    public TaskResponse createTask(
        @Valid
        @RequestBody
        TaskRequest request
    ) {

        return taskService
            .createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(

        @PathVariable Long id,

        @Valid
        @RequestBody
        TaskRequest request
    ) {

        return taskService
            .updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(
        @PathVariable Long id
    ) {

        taskService.deleteTask(id);
    }
}