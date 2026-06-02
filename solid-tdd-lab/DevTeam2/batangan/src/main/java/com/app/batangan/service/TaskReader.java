package com.app.batangan.service;

import com.app.batangan.entity.Task;
import java.util.List;

// SOLID: ISP - read-only operations separated from write operations
public interface TaskReader {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> getTasksByStatus(String status);
}