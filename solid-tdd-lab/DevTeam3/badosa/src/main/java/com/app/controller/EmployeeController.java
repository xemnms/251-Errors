package com.app.controller;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.service.EmployeeCommandService;
import com.app.service.EmployeeQueryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SOLID: ISP — The controller segregates read queries from write commands by depending on EmployeeQueryService and EmployeeCommandService separately.
// SOLID: High Cohesion — Focuses solely on web routing coordination and API mappings.
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeQueryService queryService;
    private final EmployeeCommandService commandService;

    // SOLID: DIP — The controller depends on abstractions (interfaces) rather than concrete implementations.
    public EmployeeController(EmployeeQueryService queryService, EmployeeCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return queryService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getEmployeeById(id));
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(queryService.getEmployeesByDepartment(department));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        Employee created = commandService.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        Employee updated = commandService.updateEmployee(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        commandService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
