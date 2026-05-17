package com.app.batangan.util;

import com.app.batangan.entity.Task;

// SOLID: OCP - open for extension (new handlers), closed for modification
// SOLID: DIP - service depends on this abstraction
public interface TaskPriorityHandler {
    boolean supports(String priority);
    void handle(Task task);
}