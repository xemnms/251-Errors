package com.fullstack.lab.bagay.repository;

import com.fullstack.lab.bagay.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
// GRASP: Indirection / Protected Variations - the service talks to this interface instead of persistence details.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findByLastNameContainingIgnoreCase(String lastName);
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
}