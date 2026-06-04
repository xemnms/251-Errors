package com.fullstack.lab.bagay.strategy;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeSearchStrategy {

    boolean supports(String searchField);

    List<Employee> search(EmployeeRepository employeeRepository, String query);
}