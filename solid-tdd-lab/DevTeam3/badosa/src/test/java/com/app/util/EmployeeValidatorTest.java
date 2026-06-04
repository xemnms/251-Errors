package com.app.util;

import com.app.dto.EmployeeDTO;
import com.app.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeValidatorTest {

    @Mock
    private EmployeeRepository repository;

    private EmployeeValidator validator;
    private EmployeeDTO validDTO;

    @BeforeEach
    void setUp() {
        validator = new EmployeeValidator(repository);
        validDTO = EmployeeDTO.builder()
                .name("John Doe")
                .email("john@example.com")
                .department("IT")
                .jobTitle("Developer")
                .salary(3000.0)
                .build();
    }

    @Test
    void shouldPassValidDTO() {
        when(repository.findByEmail("john@example.com")).thenReturn(Optional.empty());
        assertDoesNotThrow(() -> validator.validateForCreate(validDTO));
    }

    @Test
    void shouldThrowInvalidEmail() {
        EmployeeDTO invalidEmailDTO = EmployeeDTO.builder()
                .name("John")
                .email("invalidemail")
                .department("IT")
                .jobTitle("Dev")
                .salary(3000.0)
                .build();
        assertThrows(IllegalArgumentException.class, () -> validator.validateForCreate(invalidEmailDTO));
    }

    @Test
    void shouldThrowDuplicateEmail() {
        when(repository.findByEmail("john@example.com")).thenReturn(Optional.of(new com.app.entity.Employee()));
        assertThrows(IllegalArgumentException.class, () -> validator.validateForCreate(validDTO));
    }

    @Test
    void shouldThrowInvalidSalary() {
        EmployeeDTO invalidSalaryDTO = EmployeeDTO.builder()
                .name("John")
                .email("john@example.com")
                .department("IT")
                .jobTitle("Dev")
                .salary(-10.0)
                .build();
        assertThrows(IllegalArgumentException.class, () -> validator.validateForCreate(invalidSalaryDTO));
    }
}
