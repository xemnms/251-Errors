package com.app.dto;

import com.app.entity.Employee;
import com.app.entity.SalaryDetails;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

// OOP Best Practice: Immutability — This DTO is designed as an immutable data transfer object using Lombok's @Value, protecting the input payload from modifications.
@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class EmployeeDTO {

    @NotBlank(message = "Name is required")
    String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email;

    @NotBlank(message = "Department is required")
    String department;

    @NotBlank(message = "Job title is required")
    String jobTitle;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than zero")
    Double salary;

    Double baseSalary;
    Double allowance;

    // SOLID: Creator / OOP Best Practice: Composition — EmployeeDTO creates the Employee entity containing the composed SalaryDetails object.
    public Employee toEntity() {
        double base = (baseSalary != null) ? baseSalary : (salary != null ? salary * 0.9 : 0.0);
        double allow = (allowance != null) ? allowance : (salary != null ? salary * 0.1 : 0.0);

        return Employee.builder()
                .name(this.name)
                .email(this.email)
                .department(this.department)
                .jobTitle(this.jobTitle)
                .salaryDetails(SalaryDetails.builder()
                        .baseSalary(base)
                        .allowance(allow)
                        .build())
                .build();
    }
}
