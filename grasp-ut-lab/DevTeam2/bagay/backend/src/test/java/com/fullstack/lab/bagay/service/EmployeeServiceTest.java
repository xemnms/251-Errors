package com.fullstack.lab.bagay.service;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;
import com.fullstack.lab.bagay.strategy.EmployeeSearchStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeSearchStrategy firstNameEmployeeSearchStrategy;

    @Mock
    private EmployeeSearchStrategy lastNameEmployeeSearchStrategy;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository,
                List.of(firstNameEmployeeSearchStrategy, lastNameEmployeeSearchStrategy));
    }

    @Test
    void shouldCreateEmployee() {
        Employee employee = sampleEmployee(null);
        Employee savedEmployee = sampleEmployee(1L);

        when(employeeRepository.save(employee)).thenReturn(savedEmployee);

        Employee result = employeeService.createEmployee(employee);

        assertEquals(savedEmployee, result);
        verify(employeeRepository).save(employee);
    }

    @Test
    void shouldReturnAllEmployees() {
        List<Employee> employees = List.of(sampleEmployee(1L), sampleEmployee(2L));
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(employees, result);
        verify(employeeRepository).findAll();
    }

    @Test
    void shouldReturnEmployeeById() {
        Employee employee = sampleEmployee(1L);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);

        assertEquals(employee, result);
        verify(employeeRepository).findById(1L);
    }

    @Test
    void shouldThrowWhenEmployeeDoesNotExist() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> employeeService.getEmployeeById(1L));

        assertEquals("Employee not found with id: 1", exception.getMessage());
    }

    @Test
    void shouldUpdateEmployee() {
        Employee existingEmployee = sampleEmployee(7L);
        Employee updateRequest = sampleEmployee(null);
        updateRequest.setFirstName("Updated");

        when(employeeRepository.findById(7L)).thenReturn(Optional.of(existingEmployee));
        when(employeeRepository.save(updateRequest)).thenReturn(updateRequest);

        Employee result = employeeService.updateEmployee(7L, updateRequest);

        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(captor.capture());
        assertEquals(7L, captor.getValue().getId());
        assertEquals("Updated", result.getFirstName());
        assertEquals(7L, result.getId());
    }

    @Test
    void shouldDeleteEmployee() {
        Employee existingEmployee = sampleEmployee(3L);
        when(employeeRepository.findById(3L)).thenReturn(Optional.of(existingEmployee));

        employeeService.deleteEmployee(3L);

        verify(employeeRepository).delete(existingEmployee);
    }

    @Test
    void shouldSearchEmployeesByFirstName() {
        Employee employee = sampleEmployee(1L);

        when(firstNameEmployeeSearchStrategy.supports("firstName")).thenReturn(true);
        when(lastNameEmployeeSearchStrategy.supports("firstName")).thenReturn(false);
        when(firstNameEmployeeSearchStrategy.search(employeeRepository, "Axel")).thenReturn(List.of(employee));

        List<Employee> result = employeeService.searchEmployees("firstName", "Axel");

        assertEquals(List.of(employee), result);
        verify(firstNameEmployeeSearchStrategy).search(employeeRepository, "Axel");
    }

    @Test
    void shouldRejectUnsupportedSearchField() {
        when(firstNameEmployeeSearchStrategy.supports("department")).thenReturn(false);
        when(lastNameEmployeeSearchStrategy.supports("department")).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> employeeService.searchEmployees("department", "Axel"));

        assertEquals("Unsupported search field: department", exception.getMessage());
    }

    private Employee sampleEmployee(Long id) {
        Employee employee = new Employee(
                "Axel",
                "Bagay",
                "axel.bagay@example.com",
                "Developer",
                new BigDecimal("45000.00"),
                LocalDate.of(2026, 5, 13),
                true
        );
        employee.setId(id);
        return employee;
    }
}