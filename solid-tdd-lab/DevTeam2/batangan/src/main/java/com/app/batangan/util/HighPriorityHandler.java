package com.app.batangan.util;

import org.springframework.stereotype.Component;

import com.app.batangan.entity.Task;

// SOLID: OCP - new behavior added without modifying existing code
// SOLID: LSP - can replace TaskPriorityHandler anywhere
@Component
public class HighPriorityHandler implements TaskPriorityHandler {

    @Override
    public boolean supports(String priority) {
        return "HIGH".equals(priority);
    }

    @Override
    public void handle(Task task) {
        // KISS: simple, direct logic
        System.out.println("[URGENT] High priority task created: "
            + task.getTitle());
    }
}