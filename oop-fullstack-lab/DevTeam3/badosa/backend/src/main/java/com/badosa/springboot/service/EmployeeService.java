package com.badosa.springboot.service;

import com.badosa.springboot.dto.EmployeeDTO;
import com.badosa.springboot.model.Employee;
import com.badosa.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Transactional
    public Employee createEmployee(EmployeeDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + dto.getEmail());
        }
        Employee employee = Employee.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .department(dto.getDepartment())
                .jobTitle(dto.getJobTitle())
                .salary(dto.getSalary())
                .build();
        return repository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = getEmployeeById(id);
        
        // If email is being changed, check for duplicates
        if (!employee.getEmail().equalsIgnoreCase(dto.getEmail()) && 
            repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + dto.getEmail());
        }

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setJobTitle(dto.getJobTitle());
        employee.setSalary(dto.getSalary());

        return repository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }
}
