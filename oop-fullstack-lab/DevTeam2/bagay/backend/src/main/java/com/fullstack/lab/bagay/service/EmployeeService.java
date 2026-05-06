package com.fullstack.lab.bagay.service;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        employee.setId(existingEmployee.getId());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = getEmployeeById(id);
        employeeRepository.delete(existingEmployee);
    }
}