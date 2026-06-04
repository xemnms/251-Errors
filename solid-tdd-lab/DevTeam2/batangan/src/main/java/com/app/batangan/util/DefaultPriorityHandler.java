package com.app.batangan.util;

import org.springframework.stereotype.Component;

import com.app.batangan.entity.Task;

// SOLID: OCP - handles all non-high priorities as default
@Component
public class DefaultPriorityHandler implements TaskPriorityHandler {

    @Override
    public boolean supports(String priority) {
        return true; // fallback for LOW and MEDIUM
    }

    @Override
    public void handle(Task task) {
        System.out.println("[INFO] Task created: " + task.getTitle()
            + " | Priority: " + task.getPriority());
    }
}