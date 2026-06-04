package com.app.batangan.service;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import java.util.List;

// GRASP: Polymorphism + Protected Variations
public interface TaskService {
    Task createTask(TaskDTO dto);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateStatus(Long id, String status);
    List<Task> getTasksByStatus(String status);
    void deleteTask(Long id);
}