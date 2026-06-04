package com.fullstack.lab.bagay.service;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;
import com.fullstack.lab.bagay.strategy.EmployeeSearchStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
// GRASP: Pure Fabrication / High Cohesion - this service stays focused on employee business rules.
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final List<EmployeeSearchStrategy> employeeSearchStrategies;

    public EmployeeService(EmployeeRepository employeeRepository, List<EmployeeSearchStrategy> employeeSearchStrategies) {
        this.employeeRepository = employeeRepository;
        this.employeeSearchStrategies = employeeSearchStrategies == null ? List.of() : List.copyOf(employeeSearchStrategies);
    }

    // GRASP: Creator - the service creates and persists new employee records.
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
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

    // GRASP: Polymorphism - the right search behavior is chosen at runtime from interchangeable strategies.
    public List<Employee> searchEmployees(String searchField, String query) {
        EmployeeSearchStrategy searchStrategy = employeeSearchStrategies.stream()
                .filter(strategy -> strategy.supports(searchField))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported search field: " + searchField));
        return searchStrategy.search(employeeRepository, query);
    }
}