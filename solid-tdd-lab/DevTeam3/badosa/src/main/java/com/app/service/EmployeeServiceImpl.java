package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.entity.SalaryDetails;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import com.app.util.EmployeeValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// SOLID: SRP — Business validation logic is delegated to EmployeeValidator, leaving EmployeeServiceImpl focused strictly on transaction boundaries and business orchestrations.
// SOLID: ISP — Implements EmployeeService, satisfying the contracts of both segregated query and command interfaces.
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final NotificationService notificationService;
    private final EmployeeValidator validator;

    // SOLID: DIP — The class depends on repository/notification interfaces and validator abstractions.
    public EmployeeServiceImpl(EmployeeRepository repository, 
                               @Qualifier("emailNotificationService") NotificationService notificationService,
                               EmployeeValidator validator) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.validator = validator;
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
        // SOLID: SRP — Validate fields using the validator component
        validator.validateForCreate(dto);
        
        // GRASP: Creator pattern - We call the creator on the DTO to get the entity
        Employee employee = dto.toEntity();
        Employee saved = repository.save(employee);
        
        // GRASP: Polymorphism — Invoking sendNotification polymorphically
        notificationService.sendNotification(saved, "Welcome to the team!");
        
        return saved;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = getEmployeeById(id);

        // SOLID: SRP — Validate updating fields using the validator component
        validator.validateForUpdate(id, dto, employee.getEmail());

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setJobTitle(dto.getJobTitle());
        
        // OOP Best Practice: Composition — Compose SalaryDetails using base salary and allowance, rather than inheriting from base classes.
        double base = (dto.getBaseSalary() != null) ? dto.getBaseSalary() : (dto.getSalary() != null ? dto.getSalary() * 0.9 : 0.0);
        double allow = (dto.getAllowance() != null) ? dto.getAllowance() : (dto.getSalary() != null ? dto.getSalary() * 0.1 : 0.0);
        employee.setSalaryDetails(SalaryDetails.builder()
                .baseSalary(base)
                .allowance(allow)
                .build());

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
