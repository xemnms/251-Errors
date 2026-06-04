package com.app.controller;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.exception.GlobalExceptionHandler;
import com.app.exception.ResourceNotFoundException;
import com.app.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeController controller;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Employee employee1;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

        employee1 = Employee.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .jobTitle("Software Engineer")
                .salary(5000.0)
                .build();
    }

    @Test
    void shouldReturnAllEmployees() throws Exception {
        // Arrange
        when(service.getAllEmployees()).thenReturn(Arrays.asList(employee1));

        // Act & Assert
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"));

        verify(service, times(1)).getAllEmployees();
    }

    @Test
    void shouldCreateEmployee() throws Exception {
        // Arrange
        EmployeeDTO dto = EmployeeDTO.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .jobTitle("Software Engineer")
                .salary(5000.0)
                .build();

        when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(employee1);

        // Act & Assert
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));

        verify(service, times(1)).createEmployee(any(EmployeeDTO.class));
    }

    @Test
    void shouldReturnNotFoundForInvalidId() throws Exception {
        // Arrange
        when(service.getEmployeeById(99L)).thenThrow(new ResourceNotFoundException("Employee not found with id: 99"));

        // Act & Assert
        mockMvc.perform(get("/api/employees/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Employee not found with id: 99"));

        verify(service, times(1)).getEmployeeById(99L);
    }
}
