package com.app.batangan.service;
import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;

// SOLID: ISP - write operations separated from read operations
public interface TaskWriter {
    Task createTask(TaskDTO dto);
    Task updateStatus(Long id, String status);
    void deleteTask(Long id);
}