package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;

// SOLID: ISP — Segregates mutating state operations (create, update, delete) from queries, so mutating actions are isolated.
public interface EmployeeCommandService {
    
    Employee createEmployee(EmployeeDTO dto);
    
    Employee updateEmployee(Long id, EmployeeDTO dto);
    
    void deleteEmployee(Long id);
}
