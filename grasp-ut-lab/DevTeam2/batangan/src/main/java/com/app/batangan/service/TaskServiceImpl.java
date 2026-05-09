package com.app.batangan.service;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.repository.TaskRepository;
import com.app.batangan.util.TaskNotifier;
import com.app.batangan.util.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

// GRASP: Pure Fabrication - invented class to hold business logic cleanly
// GRASP: High Cohesion - only handles task business rules
// GRASP: Low Coupling - depends on interfaces, not concrete classes
@Service
public class TaskServiceImpl implements TaskService {

    // GRASP: Indirection - use repository, never touch DB directly
    private final TaskRepository taskRepository;

    // GRASP: Low Coupling - depend on TaskNotifier interface, not EmailTaskNotifier
    private final TaskNotifier taskNotifier;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            @Qualifier("emailNotifier") TaskNotifier taskNotifier) {
        this.taskRepository = taskRepository;
        this.taskNotifier = taskNotifier;
    }

    // GRASP: Creator - Service creates Task from DTO
    @Override
    public Task createTask(TaskDTO dto) {
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }

        Task task = new Task();
        task.setTitle(dto.getTitle().trim());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority() != null ? dto.getPriority() : "MEDIUM");
        task.setAssignedTo(dto.getAssignedTo());
        task.setStatus("PENDING"); // always starts as PENDING

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