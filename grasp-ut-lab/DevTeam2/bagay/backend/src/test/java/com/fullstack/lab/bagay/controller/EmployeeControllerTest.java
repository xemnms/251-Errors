package com.fullstack.lab.bagay.controller;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void shouldReturnAllEmployees() {
        List<Employee> employees = List.of(sampleEmployee(1L));
        when(employeeService.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
        verify(employeeService).getAllEmployees();
    }

    @Test
    void shouldSearchEmployees() {
        List<Employee> employees = List.of(sampleEmployee(1L));
        when(employeeService.searchEmployees("firstName", "Axel")).thenReturn(employees);

        ResponseEntity<List<Employee>> response = employeeController.searchEmployees("firstName", "Axel");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
        verify(employeeService).searchEmployees("firstName", "Axel");
    }

    @Test
    void shouldReturnEmployeeById() {
        Employee employee = sampleEmployee(1L);
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
        verify(employeeService).getEmployeeById(1L);
    }

    @Test
    void shouldReturnNotFoundWhenEmployeeIsMissing() {
        when(employeeService.getEmployeeById(1L)).thenThrow(new EntityNotFoundException("Employee not found with id: 1"));

        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody() == null);
    }

    @Test
    void shouldCreateEmployee() {
        Employee employee = sampleEmployee(null);
        Employee createdEmployee = sampleEmployee(1L);
        when(employeeService.createEmployee(employee)).thenReturn(createdEmployee);

        ResponseEntity<Employee> response = employeeController.createEmployee(employee);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdEmployee, response.getBody());
        verify(employeeService).createEmployee(employee);
    }

    @Test
    void shouldUpdateEmployee() {
        Employee employee = sampleEmployee(null);
        Employee updatedEmployee = sampleEmployee(1L);
        when(employeeService.updateEmployee(1L, employee)).thenReturn(updatedEmployee);

        ResponseEntity<Employee> response = employeeController.updateEmployee(1L, employee);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedEmployee, response.getBody());
        verify(employeeService).updateEmployee(1L, employee);
    }

    @Test
    void shouldDeleteEmployee() {
        ResponseEntity<Void> response = employeeController.deleteEmployee(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(response.getBody() == null);
        verify(employeeService).deleteEmployee(1L);
    }

    @Test
    void shouldReturnNotFoundWhenDeleteFails() {
        doThrow(new EntityNotFoundException("Employee not found with id: 1"))
                .when(employeeService).deleteEmployee(1L);

        ResponseEntity<Void> response = employeeController.deleteEmployee(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.hasBody());
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