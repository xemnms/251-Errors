package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// GRASP: High Cohesion — This class is responsible only for representing an Employee domain entity.
@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false, name = "job_title")
    private String jobTitle;

    @jakarta.persistence.Embedded
    private SalaryDetails salaryDetails;

    // SOLID: SRP / OOP Best Practice: Composition — Provides a getter to return computed salary value, maintaining contract compatibility.
    public Double getSalary() {
        return this.salaryDetails != null ? this.salaryDetails.getTotalMonthlySalary() : 0.0;
    }

    // GRASP: Information Expert — Employee calculates its own annual salary by querying its composed salaryDetails expert.
    public Double calculateAnnualSalary() {
        return this.salaryDetails != null ? this.salaryDetails.getTotalMonthlySalary() * 12 : 0.0;
    }

    // GRASP: Information Expert — Employee knows its own department, so it is the expert responsible for verifying department membership.
    public boolean isInDepartment(String dept) {
        if (dept == null || this.department == null) {
            return false;
        }
        return this.department.equalsIgnoreCase(dept.trim());
    }
}
