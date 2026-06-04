package com.app.batangan.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.app.batangan.entity.Task;

// OCP proof — new handlers added without changing existing code
class TaskPriorityHandlerTest {

    // TEST 1: HighPriorityHandler supports HIGH
    @Test
    void highHandlerSupportsPriority() {
        TaskPriorityHandler handler = new HighPriorityHandler();
        assertTrue(handler.supports("HIGH"));
        assertFalse(handler.supports("LOW"));
    }

    // TEST 2: DefaultPriorityHandler is the fallback
    @Test
    void defaultHandlerSupportsFallback() {
        TaskPriorityHandler handler = new DefaultPriorityHandler();
        assertTrue(handler.supports("LOW"));
        assertTrue(handler.supports("MEDIUM"));
    }

    // TEST 3: LSP — both handlers substitute TaskPriorityHandler
    @Test
    void bothHandlersSubstituteInterface() {
        Task task = new Task();
        task.setTitle("Test"); task.setPriority("HIGH");

        TaskPriorityHandler high = new HighPriorityHandler();
        TaskPriorityHandler def = new DefaultPriorityHandler();

        assertDoesNotThrow(() -> high.handle(task));
        assertDoesNotThrow(() -> def.handle(task));
    }
}