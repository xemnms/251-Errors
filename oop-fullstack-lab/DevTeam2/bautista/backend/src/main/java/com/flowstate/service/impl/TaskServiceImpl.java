package com.flowstate.service.impl;

import com.flowstate.dto.TaskRequest;
import com.flowstate.dto.TaskResponse;

import com.flowstate.entity.Task;

import com.flowstate.exception.ResourceNotFoundException;

import com.flowstate.repository.TaskRepository;

import com.flowstate.service.TaskService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TaskServiceImpl
    implements TaskService {

    private final
    TaskRepository taskRepository;

    @Override
    public List<TaskResponse>
    getAllTasks() {

        return taskRepository
            .findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    public TaskResponse createTask(
        TaskRequest request
    ) {

        Task task = Task.builder()
            .title(request.getTitle())
            .description(
                request.getDescription()
            )
            .status(request.getStatus())
            .createdAt(
                LocalDateTime.now()
            )
            .build();

        Task savedTask =
            taskRepository.save(task);

        return mapToResponse(
            savedTask
        );
    }

    @Override
    public TaskResponse updateTask(
        Long id,
        TaskRequest request
    ) {

        Task task =
            taskRepository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Task not found"
                )
            );

        task.setTitle(
            request.getTitle()
        );

        task.setDescription(
            request.getDescription()
        );

        task.setStatus(
            request.getStatus()
        );

        Task updatedTask =
            taskRepository.save(task);

        return mapToResponse(
            updatedTask
        );
    }

    @Override
    public void deleteTask(Long id) {

        Task task =
            taskRepository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Task not found"
                )
            );

        taskRepository.delete(task);
    }

    private TaskResponse
    mapToResponse(Task task) {

        return TaskResponse.builder()
            .id(task.getId())
            .title(task.getTitle())
            .description(
                task.getDescription()
            )
            .status(task.getStatus())
            .createdAt(
                task.getCreatedAt()
            )
            .build();
    }
}