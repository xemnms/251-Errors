package com.app.batangan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.repository.TaskRepository;
import com.app.batangan.util.TaskMapper;
import com.app.batangan.util.TaskNotFoundException;
import com.app.batangan.util.TaskNotifier;
import com.app.batangan.util.TaskPriorityHandler;
import com.app.batangan.util.TaskValidator;

// SOLID: SRP - orchestrates business logic only (no validation/mapping here)
// SOLID: DIP - depends on interfaces: TaskRepository, TaskNotifier,
//              TaskValidator, TaskMapper, TaskPriorityHandler
// OOP: Composition - HAS-A validator, mapper, notifier (not extends)
@Service
public class TaskServiceImpl implements TaskService {

    // DIP: all dependencies are interfaces, not concrete classes
    private final TaskRepository taskRepository;
    private final TaskNotifier taskNotifier;
    private final TaskValidator taskValidator;
    private final TaskMapper taskMapper;
    private final List<TaskPriorityHandler> priorityHandlers;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            @Qualifier("emailNotifier") TaskNotifier taskNotifier,
            TaskValidator taskValidator,
            TaskMapper taskMapper,
            List<TaskPriorityHandler> priorityHandlers) {
        this.taskRepository = taskRepository;
        this.taskNotifier = taskNotifier;
        this.taskValidator = taskValidator;
        this.taskMapper = taskMapper;
        this.priorityHandlers = priorityHandlers;
    }

    @Override
    public Task createTask(TaskDTO dto) {
        // SRP: validation delegated to TaskValidator
        taskValidator.validate(dto);

        // SRP: mapping delegated to TaskMapper
        Task task = taskMapper.toEntity(dto);

        // OCP: priority handling via strategy — no if-else!
        priorityHandlers.stream()
            .filter(h -> h.supports(task.getPriority()))
            .findFirst()
            .ifPresent(h -> h.handle(task));

        Task saved = taskRepository.save(task);
        taskNotifier.notify(saved, "CREATED");
        return saved;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public Task updateStatus(Long id, String status) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException(id));
        task.setStatus(status);
        Task saved = taskRepository.save(task);
        taskNotifier.notify(saved, "STATUS_UPDATED");
        return saved;
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}