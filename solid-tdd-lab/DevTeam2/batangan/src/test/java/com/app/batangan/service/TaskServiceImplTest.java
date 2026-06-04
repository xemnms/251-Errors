package com.app.batangan.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.repository.TaskRepository;
import com.app.batangan.util.TaskMapper;
import com.app.batangan.util.TaskNotFoundException;
import com.app.batangan.util.TaskNotifier;
import com.app.batangan.util.TaskValidator;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    // DIP: mocking interfaces, not concrete classes
    @Mock TaskRepository taskRepository;
    @Mock TaskNotifier taskNotifier;
    @Mock TaskValidator taskValidator;
    @Mock TaskMapper taskMapper;

    TaskServiceImpl taskService;

    private TaskDTO dto;
    private Task task;

    @BeforeEach
    void setUp() {
    taskService = new TaskServiceImpl(
        taskRepository,
        taskNotifier,
        taskValidator,
        taskMapper,
        java.util.Collections.emptyList()  // ← real empty list
    );

    dto = new TaskDTO.Builder()
        .title("Fix login bug")
        .priority("HIGH")
        .assignedTo("Alice")
        .build();

    task = new Task();
    task.setId(1L);
    task.setTitle("Fix login bug");
    task.setStatus("PENDING");
    task.setPriority("HIGH");
}

    // TEST 1: SRP — validator is called (not duplicated in service)
    @Test
    void shouldCallValidatorOnCreate() {
        when(taskMapper.toEntity(dto)).thenReturn(task);
        when(taskRepository.save(task)).thenReturn(task);

        taskService.createTask(dto);

        verify(taskValidator, times(1)).validate(dto);
    }

    // TEST 2: SRP — mapper is called (not duplicated in service)
    @Test
    void shouldCallMapperOnCreate() {
        when(taskMapper.toEntity(dto)).thenReturn(task);
        when(taskRepository.save(task)).thenReturn(task);

        taskService.createTask(dto);

        verify(taskMapper, times(1)).toEntity(dto);
    }

    // TEST 3: DIP — notifier interface is called, not concrete class
    @Test
    void shouldCallNotifierAfterCreate() {
        when(taskMapper.toEntity(dto)).thenReturn(task);
        when(taskRepository.save(task)).thenReturn(task);

        taskService.createTask(dto);

        verify(taskNotifier).notify(task, "CREATED");
    }

    // TEST 4: edge case — null input
    @Test
    void shouldHandleNullDTOGracefully() {
        doThrow(new IllegalArgumentException("null"))
            .when(taskValidator).validate(null);

        assertThrows(IllegalArgumentException.class,
            () -> taskService.createTask(null));

        verify(taskRepository, never()).save(any());
    }

    // TEST 5: happy path — get all tasks
    @Test
    void shouldReturnAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
    }

    // TEST 6: edge case — empty collection
    @Test
    void shouldReturnEmptyListWhenNoTasks() {
        when(taskRepository.findAll()).thenReturn(Collections.emptyList());

        List<Task> result = taskService.getAllTasks();

        assertTrue(result.isEmpty());
    }

    // TEST 7: update status — happy path
    @Test
    void shouldUpdateStatus() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.updateStatus(1L, "DONE");

        assertEquals("DONE", result.getStatus());
        verify(taskNotifier).notify(task, "STATUS_UPDATED");
    }

    // TEST 8: edge case — task not found on update
    @Test
    void shouldThrowWhenTaskNotFound() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
            () -> taskService.updateStatus(99L, "DONE"));
    }

    // TEST 9: edge case — delete non-existent task
    @Test
    void shouldThrowWhenDeletingMissingTask() {
        when(taskRepository.existsById(99L)).thenReturn(false);

        assertThrows(TaskNotFoundException.class,
            () -> taskService.deleteTask(99L));

        verify(taskRepository, never()).deleteById(any());
    }

    // TEST 10: Information Expert still works
    @Test
    void taskShouldKnowItsOwnState() {
        task.setStatus("DONE");
        assertTrue(task.isCompleted());
        task.setStatus("PENDING");
        assertFalse(task.isCompleted());
    }
}