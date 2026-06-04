package com.flowstate.service;

import com.flowstate.dto.TaskRequest;
import com.flowstate.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAllTasks();

    TaskResponse createTask(
        TaskRequest request
    );

    TaskResponse updateTask(
        Long id,
        TaskRequest request
    );

    void deleteTask(Long id);
}