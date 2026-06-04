package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;

import java.util.List;

// SOLID: ISP — Refactored to extend segregated interfaces, ensuring backwards compatibility while segregating read and write operations.
// GRASP: Protected Variations — Keeps caller components protected from backend changes.
public interface EmployeeService extends EmployeeQueryService, EmployeeCommandService {
}
