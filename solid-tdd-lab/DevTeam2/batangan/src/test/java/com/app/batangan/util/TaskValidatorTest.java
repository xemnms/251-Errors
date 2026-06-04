package com.app.batangan.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.app.batangan.dto.TaskDTO;

// SRP proof: validator has its own dedicated tests
// DRY proof: all validation tested in one place
class TaskValidatorTest {

    private TaskValidator validator;

    @BeforeEach
    void setUp() {
        validator = new TaskValidator();
    }

    // TEST 1: valid input passes
    @Test
    void shouldPassValidInput() {
        TaskDTO dto = new TaskDTO.Builder()
            .title("Valid task")
            .priority("HIGH")
            .build();

        assertDoesNotThrow(() -> validator.validate(dto));
    }

    // TEST 2: null DTO throws
    @Test
    void shouldThrowOnNullDTO() {
        assertThrows(IllegalArgumentException.class,
            () -> validator.validate(null));
    }

    // TEST 3: empty title throws
    @Test
    void shouldThrowOnEmptyTitle() {
        TaskDTO dto = new TaskDTO.Builder().title("").build();
        assertThrows(IllegalArgumentException.class,
            () -> validator.validate(dto));
    }

    // TEST 4: blank title throws
    @Test
    void shouldThrowOnBlankTitle() {
        TaskDTO dto = new TaskDTO.Builder().title("   ").build();
        assertThrows(IllegalArgumentException.class,
            () -> validator.validate(dto));
    }

    // BONUS: Parameterized test — invalid priorities
    @ParameterizedTest
    @ValueSource(strings = {"CRITICAL", "URGENT", "low", "high", ""})
    void shouldThrowOnInvalidPriority(String priority) {
        TaskDTO dto = new TaskDTO.Builder()
            .title("Task")
            .priority(priority)
            .build();
        assertThrows(IllegalArgumentException.class,
            () -> validator.validate(dto));
    }
}