package com.app.batangan.dto;

// SOLID: SRP - only carries data, no logic
// OOP: Immutability - final fields cannot be changed after creation
// OOP: YAGNI - only fields actually needed are here
public class TaskDTO {

    private final String title;
    private final String description;
    private final String priority;
    private final String assignedTo;

    // Private constructor — use Builder to create
    private TaskDTO(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.assignedTo = builder.assignedTo;
    }

    // Getters ONLY — no setters (immutability)
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public String getAssignedTo() { return assignedTo; }

    // OOP: Composition - Builder is a separate helper, not inheritance
    public static class Builder {
        private String title;
        private String description;
        private String priority;
        private String assignedTo;

        public Builder title(String title) {
            this.title = title; return this;
        }
        public Builder description(String description) {
            this.description = description; return this;
        }
        public Builder priority(String priority) {
            this.priority = priority; return this;
        }
        public Builder assignedTo(String assignedTo) {
            this.assignedTo = assignedTo; return this;
        }
        public TaskDTO build() {
            return new TaskDTO(this);
        }
    }
}