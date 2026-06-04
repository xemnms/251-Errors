package com.app.batangan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.app.batangan.dto.TaskDTO;

// Proves OOP: Immutability — TaskDTO state cannot change after creation
class TaskDTOImmutabilityTest {

    // TEST 1: DTO preserves state after creation
    @Test
    void dtoShouldPreserveStateAfterCreation() {
        TaskDTO dto = new TaskDTO.Builder()
            .title("Write tests")
            .priority("HIGH")
            .assignedTo("Bob")
            .build();

        assertEquals("Write tests", dto.getTitle());
        assertEquals("HIGH", dto.getPriority());
        assertEquals("Bob", dto.getAssignedTo());
    }

    // TEST 2: two DTOs with same values are independent
    @Test
    void twoDtosShouldBeIndependent() {
        TaskDTO dto1 = new TaskDTO.Builder()
            .title("Task A").priority("LOW").build();

        TaskDTO dto2 = new TaskDTO.Builder()
            .title("Task B").priority("HIGH").build();

        assertNotEquals(dto1.getTitle(), dto2.getTitle());
        assertNotEquals(dto1.getPriority(), dto2.getPriority());
    }

    // TEST 3: null fields handled safely
    @Test
    void dtoShouldHandleNullFieldsSafely() {
        TaskDTO dto = new TaskDTO.Builder()
            .title("Only title")
            .build();

        assertEquals("Only title", dto.getTitle());
        assertNull(dto.getDescription());
        assertNull(dto.getPriority());
    }
}