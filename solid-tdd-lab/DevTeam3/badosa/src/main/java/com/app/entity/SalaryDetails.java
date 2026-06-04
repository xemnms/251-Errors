package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// OOP Best Practice: Composition Over Inheritance — The Employee entity uses composition (HAS-A SalaryDetails) instead of inheritance (e.g. subclassing into SalariedEmployee).
// OOP Best Practice: Immutability — Declaring all fields final with no setters guarantees that the SalaryDetails state cannot be modified once instantiated.
@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public final class SalaryDetails {

    @Column(name = "base_salary", nullable = false)
    private final Double baseSalary;

    @Column(name = "allowance", nullable = false)
    private final Double allowance;

    // SOLID: SRP — Responsible strictly for combining the base salary and allowance components.
    public Double getTotalMonthlySalary() {
        return (baseSalary != null ? baseSalary : 0.0) + (allowance != null ? allowance : 0.0);
    }
}
