package com.app.batangan.util;

import org.springframework.stereotype.Component;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;

// SOLID: SRP - this class has ONE job: convert DTO to entity
// KISS: simple, readable mapping logic
@Component
public class TaskMapper {

    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle().trim());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority() != null ? dto.getPriority() : "MEDIUM");
        task.setAssignedTo(dto.getAssignedTo());
        task.setStatus("PENDING");
        return task;
    }
}