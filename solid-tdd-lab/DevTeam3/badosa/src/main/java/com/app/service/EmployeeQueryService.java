package com.app.service;

import com.app.entity.Employee;

import java.util.List;

// SOLID: ISP — Split the fat service interface so clients who only need to query data are not forced to depend on mutation operations.
public interface EmployeeQueryService {
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(Long id);
    
    List<Employee> getEmployeesByDepartment(String department);
}
