package com.app.batangan.service;

import com.app.batangan.dto.TaskDTO;
import com.app.batangan.entity.Task;
import com.app.batangan.repository.TaskRepository;
import com.app.batangan.util.TaskNotifier;
import com.app.batangan.util.TaskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)   // activates Mockito
class TaskServiceImplTest {

    @Mock   // fake repository — no real DB
    TaskRepository taskRepository;

    @Mock   // fake notifier — no real emails
    TaskNotifier taskNotifier;

    @InjectMocks   // creates TaskServiceImpl with the mocks injected
    TaskServiceImpl taskService;

    private TaskDTO sampleDTO;
    private Task sampleTask;

    @BeforeEach
    void setUp() {
        sampleDTO = new TaskDTO();
        sampleDTO.setTitle("Fix login bug");
        sampleDTO.setPriority("HIGH");
        sampleDTO.setAssignedTo("Alice");

        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Fix login bug");
        sampleTask.setStatus("PENDING");
        sampleTask.setPriority("HIGH");
        sampleTask.setAssignedTo("Alice");
    }

    // TEST 1: happy path - task is created correctly
    @Test
    void shouldCreateTaskWithPendingStatus() {
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);

        Task result = taskService.createTask(sampleDTO);

        assertEquals("PENDING", result.getStatus());
        assertEquals("Fix login bug", result.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
        verify(taskNotifier, times(1)).notify(any(Task.class), eq("CREATED"));
    }

    // TEST 2: edge case - empty title throws exception
    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        sampleDTO.setTitle("   "); // blank title

        assertThrows(IllegalArgumentException.class,
            () -> taskService.createTask(sampleDTO));

        verify(taskRepository, never()).save(any()); // DB must NOT be called
    }

    // TEST 3: null title also throws
    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        sampleDTO.setTitle(null);

        assertThrows(IllegalArgumentException.class,
            () -> taskService.createTask(sampleDTO));
    }

    // TEST 4: get all tasks returns correct list
    @Test
    void shouldReturnAllTasks() {
        Task t2 = new Task(); t2.setTitle("Deploy app");
        when(taskRepository.findAll()).thenReturn(List.of(sampleTask, t2));

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        verify(taskRepository, times(1)).findAll();
    }

    // TEST 5: update status works correctly
    @Test
    void shouldUpdateTaskStatusToDone() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        when(taskRepository.save(sampleTask)).thenReturn(sampleTask);

        Task result = taskService.updateStatus(1L, "DONE");

        assertEquals("DONE", result.getStatus());
        verify(taskNotifier).notify(sampleTask, "STATUS_UPDATED");
    }

    // TEST 6: throws when task not found on update
    @Test
    void shouldThrowWhenUpdatingNonExistentTask() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
            () -> taskService.updateStatus(99L, "DONE"));
    }

    // TEST 7: delete throws when task doesn't exist
    @Test
    void shouldThrowWhenDeletingNonExistentTask() {
        when(taskRepository.existsById(99L)).thenReturn(false);

        assertThrows(TaskNotFoundException.class,
            () -> taskService.deleteTask(99L));

        verify(taskRepository, never()).deleteById(any());
    }

    // TEST 8: Information Expert - task knows if it's completed
    @Test
    void shouldCorrectlyDetectCompletedTask() {
        sampleTask.setStatus("DONE");
        assertTrue(sampleTask.isCompleted());

        sampleTask.setStatus("PENDING");
        assertFalse(sampleTask.isCompleted());
    }

    // TEST 9: Polymorphism - notifier is called regardless of implementation
    @Test
    void shouldCallNotifierOnCreate() {
        when(taskRepository.save(any())).thenReturn(sampleTask);

        taskService.createTask(sampleDTO);

        verify(taskNotifier, times(1)).notify(any(Task.class), eq("CREATED"));
    }
}