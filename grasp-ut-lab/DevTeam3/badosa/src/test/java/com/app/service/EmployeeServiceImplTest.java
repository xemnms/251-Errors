package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private EmployeeServiceImpl service;

    private Employee employee1;
    private Employee employee2;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        employee1 = Employee.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .jobTitle("Software Engineer")
                .salary(5000.0)
                .build();

        employee2 = Employee.builder()
                .id(2L)
                .name("Jane Smith")
                .email("jane.smith@example.com")
                .department("HR")
                .jobTitle("HR Manager")
                .salary(4500.0)
                .build();

        employeeDTO = EmployeeDTO.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .jobTitle("Software Engineer")
                .salary(5000.0)
                .build();
    }

    @Test
    void shouldGetAllEmployees() {
        // Arrange
        when(repository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        // Act
        List<Employee> result = service.getAllEmployees();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetEmployeeById() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(employee1));

        // Act
        Employee result = service.getEmployeeById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowWhenEmployeeNotFound() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> service.getEmployeeById(99L));
        verify(repository, times(1)).findById(99L);
    }

    @Test
    void shouldCreateEmployee() {
        // Arrange
        when(repository.findByEmail(employeeDTO.getEmail())).thenReturn(Optional.empty());
        when(repository.save(any(Employee.class))).thenReturn(employee1);

        // Act
        Employee result = service.createEmployee(employeeDTO);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(repository, times(1)).findByEmail(employeeDTO.getEmail());
        verify(repository, times(1)).save(any(Employee.class));
        verify(notificationService, times(1)).sendNotification(any(Employee.class), anyString());
    }

    @Test
    void shouldThrowWhenDuplicateEmail() {
        // Arrange
        when(repository.findByEmail(employeeDTO.getEmail())).thenReturn(Optional.of(employee1));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.createEmployee(employeeDTO));
        verify(repository, times(1)).findByEmail(employeeDTO.getEmail());
        verify(repository, never()).save(any(Employee.class));
        verify(notificationService, never()).sendNotification(any(Employee.class), anyString());
    }

    @Test
    void shouldUpdateEmployee() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(employee1));
        when(repository.save(any(Employee.class))).thenReturn(employee1);

        EmployeeDTO updateDTO = EmployeeDTO.builder()
                .name("John Updated")
                .email("john.doe@example.com") // same email
                .department("Engineering")
                .jobTitle("Senior Engineer")
                .salary(6000.0)
                .build();

        // Act
        Employee result = service.updateEmployee(1L, updateDTO);

        // Assert
        assertNotNull(result);
        assertEquals("John Updated", result.getName());
        assertEquals("Senior Engineer", result.getJobTitle());
        assertEquals(6000.0, result.getSalary());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Employee.class));
        verify(notificationService, times(1)).sendNotification(any(Employee.class), anyString());
    }

    @Test
    void shouldDeleteEmployee() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(employee1));
        doNothing().when(repository).delete(employee1);

        // Act
        service.deleteEmployee(1L);

        // Assert
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(employee1);
        verify(notificationService, times(1)).sendNotification(employee1, "Your profile has been deleted.");
    }

    @Test
    void shouldGetEmployeesByDepartment() {
        // Arrange
        when(repository.findByDepartment("Engineering")).thenReturn(Collections.singletonList(employee1));

        // Act
        List<Employee> result = service.getEmployeesByDepartment("Engineering");

        // Assert
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
        verify(repository, times(1)).findByDepartment("Engineering");
    }
}
