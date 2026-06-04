package com.app.batangan.util;
// GRASP: High Cohesion - one class, one purpose: signal a missing task
// Bonus: Custom exception handling
public class TaskNotFoundException extends RuntimeException {

    private final Long taskId;

    public TaskNotFoundException(Long taskId) {
        super("Task not found with ID: " + taskId);
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
}