package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// GRASP: Pure Fabrication — EmployeeServiceImpl is a pure fabrication class created to manage business logic operations, keeping domain entities clean.
// GRASP: High Cohesion — It is solely focused on managing employee operations.
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final NotificationService notificationService;

    // GRASP: Low Coupling — The class depends on the EmployeeRepository and NotificationService interfaces, not concrete implementations.
    public EmployeeServiceImpl(EmployeeRepository repository, 
                               @Qualifier("emailNotificationService") NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    @Override
    @Transactional
    public Employee createEmployee(EmployeeDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + dto.getEmail());
        }
        
        // GRASP: Creator pattern - We call the creator on the DTO to get the entity
        Employee employee = dto.toEntity();
        Employee saved = repository.save(employee);
        
        // GRASP: Polymorphism — Invoking sendNotification on the NotificationService interface, which behaves differently depending on the runtime type
        notificationService.sendNotification(saved, "Welcome to the team!");
        
        return saved;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = getEmployeeById(id);

        if (!employee.getEmail().equalsIgnoreCase(dto.getEmail()) &&
                repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + dto.getEmail());
        }

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setJobTitle(dto.getJobTitle());
        employee.setSalary(dto.getSalary());

        Employee updated = repository.save(employee);
        
        // GRASP: Polymorphism in action
        notificationService.sendNotification(updated, "Your employee details were updated.");
        
        return updated;
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
        
        // GRASP: Polymorphism in action
        notificationService.sendNotification(employee, "Your profile has been deleted.");
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
