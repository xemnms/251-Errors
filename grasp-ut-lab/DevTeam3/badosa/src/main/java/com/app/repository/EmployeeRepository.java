package com.app.repository;

import com.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// GRASP: Indirection — This repository acts as an intermediary (indirection layer) between the business logic (service layer) and the data source (database).
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartment(String department);
}
