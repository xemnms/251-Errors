package com.app.batangan.util;

import com.app.batangan.entity.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism test - both implementations satisfy the contract
class TaskNotifierTest {

    @Test
    void emailNotifierShouldImplementInterface() {
        // Arrange
        TaskNotifier notifier = new EmailTaskNotifier();
        Task task = new Task();
        task.setTitle("Test Task");
        task.setAssignedTo("Bob");

        // Act + Assert - should not throw any exception
        assertDoesNotThrow(() -> notifier.notify(task, "CREATED"));
    }

    @Test
    void consoleNotifierShouldImplementInterface() {
        // Arrange
        TaskNotifier notifier = new ConsoleTaskNotifier();
        Task task = new Task();
        task.setTitle("Test Task");
        task.setStatus("PENDING");

        // Act + Assert
        assertDoesNotThrow(() -> notifier.notify(task, "DELETED"));
    }

    @Test
    void bothNotifiersShareSameInterface() {
        // GRASP: Polymorphism - assign either impl to the same variable type
        TaskNotifier emailNotifier = new EmailTaskNotifier();
        TaskNotifier consoleNotifier = new ConsoleTaskNotifier();

        assertNotNull(emailNotifier);
        assertNotNull(consoleNotifier);

        // Both are TaskNotifier - polymorphism proven
        assertTrue(emailNotifier instanceof TaskNotifier);
        assertTrue(consoleNotifier instanceof TaskNotifier);
    }

    @Test
    void taskShouldKnowItsOwnStatus() {
        // GRASP: Information Expert - Task owns its logic
        Task task = new Task();
        task.setStatus("DONE");
        task.setPriority("HIGH");

        assertTrue(task.isCompleted());
        assertTrue(task.isHighPriority());
        assertFalse(task.isInProgress());
    }
}