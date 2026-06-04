package com.app.batangan.util;

import org.springframework.stereotype.Component;

import com.app.batangan.dto.TaskDTO;

// SOLID: SRP - this class has ONE job: validate task input
// DRY: all validation logic lives here, not repeated across classes
@Component
public class TaskValidator {

    public void validate(TaskDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Task data cannot be null");
        }
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        if (dto.getPriority() != null) {
            validatePriority(dto.getPriority());
        }
    }

    private void validatePriority(String priority) {
        if (!priority.equals("LOW") &&
            !priority.equals("MEDIUM") &&
            !priority.equals("HIGH")) {
            throw new IllegalArgumentException(
                "Priority must be LOW, MEDIUM, or HIGH");
        }
    }
}