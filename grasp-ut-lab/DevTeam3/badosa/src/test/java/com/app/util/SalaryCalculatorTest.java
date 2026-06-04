package com.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorTest {

    @Test
    void shouldCalculateAnnualSalary() {
        assertEquals(60000.0, SalaryCalculator.calculateAnnualSalary(5000.0));
        assertEquals(0.0, SalaryCalculator.calculateAnnualSalary(0.0));
    }

    @Test
    void shouldCalculateTax() {
        assertEquals(1000.0, SalaryCalculator.calculateTax(5000.0));
        assertEquals(0.0, SalaryCalculator.calculateTax(0.0));
        assertThrows(IllegalArgumentException.class, () -> SalaryCalculator.calculateTax(-500.0));
    }

    @Test
    void shouldCalculateNetPay() {
        assertEquals(4000.0, SalaryCalculator.calculateNetPay(5000.0));
        assertEquals(0.0, SalaryCalculator.calculateNetPay(0.0));
        assertThrows(IllegalArgumentException.class, () -> SalaryCalculator.calculateNetPay(-100.0));
    }
}
