package com.app.dto;

import com.app.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than zero")
    private Double salary;

    // GRASP: Creator — EmployeeDTO holds all the necessary data to initialize an Employee, making it an appropriate Creator for the Employee entity.
    public Employee toEntity() {
        return Employee.builder()
                .name(this.name)
                .email(this.email)
                .department(this.department)
                .jobTitle(this.jobTitle)
                .salary(this.salary)
                .build();
    }
}
