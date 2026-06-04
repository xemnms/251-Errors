package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;

import java.util.List;

// GRASP: Protected Variations — This interface protects callers from variations/changes in the service implementation.
// GRASP: Low Coupling — External classes depend on this interface instead of the concrete implementation class, keeping coupling to a minimum.
public interface EmployeeService {
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(Long id);
    
    Employee createEmployee(EmployeeDTO dto);
    
    Employee updateEmployee(Long id, EmployeeDTO dto);
    
    void deleteEmployee(Long id);
    
    List<Employee> getEmployeesByDepartment(String department);
}
