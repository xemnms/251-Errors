package com.app.batangan.dto;

// GRASP: Low Coupling - decouples the API input from the internal entity
// Bonus: DTO pattern prevents exposing internal database fields
public class TaskDTO {

    private String title;
    private String description;
    private String priority;  // "LOW", "MEDIUM", "HIGH"
    private String assignedTo;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
}