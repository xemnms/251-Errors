package com.app.batangan.service;

// SOLID: ISP - TaskService combines both only where full access is needed
// SOLID: OCP - new operations added via new interfaces, not editing this
public interface TaskService extends TaskReader, TaskWriter {
    // intentionally empty — inherits all methods from both interfaces
}