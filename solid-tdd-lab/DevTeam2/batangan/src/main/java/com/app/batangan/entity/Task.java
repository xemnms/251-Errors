package com.app.batangan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// GRASP: Information Expert - Task owns its data and its logic
// GRASP: Creator - Task is responsible for its own state
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    // Values: "PENDING", "IN_PROGRESS", "DONE"
    @Column(nullable = false)
    private String status;

    // Values: "LOW", "MEDIUM", "HIGH"
    private String priority;

    private String assignedTo;

    // GRASP: Information Expert - logic lives in the class that owns the data
    public boolean isCompleted() {
        return "DONE".equals(this.status);
    }

    public boolean isHighPriority() {
        return "HIGH".equals(this.priority);
    }

    public boolean isInProgress() {
        return "IN_PROGRESS".equals(this.status);
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
}