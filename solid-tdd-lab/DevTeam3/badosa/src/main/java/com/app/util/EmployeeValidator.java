package com.app.util;

import com.app.dto.EmployeeDTO;
import com.app.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

// SOLID: SRP — EmployeeValidator is responsible exclusively for executing custom business rules and validation checks.
@Component
public class EmployeeValidator {

    private final EmployeeRepository repository;

    public EmployeeValidator(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void validateForCreate(EmployeeDTO dto) {
        validateEmailFormat(dto.getEmail());
        validateEmailUnique(dto.getEmail());
        validateSalary(dto.getSalary());
    }

    public void validateForUpdate(Long id, EmployeeDTO dto, String existingEmail) {
        validateEmailFormat(dto.getEmail());
        if (!existingEmail.equalsIgnoreCase(dto.getEmail())) {
            validateEmailUnique(dto.getEmail());
        }
        validateSalary(dto.getSalary());
    }

    // SOLID: DRY — Reusable email format validation.
    private void validateEmailFormat(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }

    // SOLID: DRY — Reusable duplicate check validator.
    private void validateEmailUnique(String email) {
        if (repository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + email);
        }
    }

    // SOLID: DRY — Reusable salary value validator.
    private void validateSalary(Double salary) {
        if (salary == null || salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        }
    }
}
