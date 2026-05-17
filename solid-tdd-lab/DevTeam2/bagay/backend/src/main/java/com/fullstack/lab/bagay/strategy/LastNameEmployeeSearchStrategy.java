package com.fullstack.lab.bagay.strategy;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// GRASP: Polymorphism - this strategy provides another interchangeable search implementation.
public class LastNameEmployeeSearchStrategy implements EmployeeSearchStrategy {

    @Override
    public boolean supports(String searchField) {
        return "lastName".equalsIgnoreCase(searchField);
    }

    @Override
    public List<Employee> search(EmployeeRepository employeeRepository, String query) {
        return employeeRepository.findByLastNameContainingIgnoreCase(query);
    }
}