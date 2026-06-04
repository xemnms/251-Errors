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
    void shouldCalculateTaxUsingStrategy() {
        TaxStrategy standard = new StandardTaxStrategy();
        TaxStrategy highIncome = new HighIncomeTaxStrategy();

        // Under/equal 5000: Standard (20%)
        assertEquals(1000.0, SalaryCalculator.calculateTax(5000.0, standard));
        // Over 5000: High Income (30%)
        assertEquals(1800.0, SalaryCalculator.calculateTax(6000.0, highIncome));

        assertThrows(IllegalArgumentException.class, () -> SalaryCalculator.calculateTax(-500.0, standard));
        assertThrows(IllegalArgumentException.class, () -> SalaryCalculator.calculateTax(5000.0, null));
    }

    @Test
    void shouldCalculateNetPayUsingStrategy() {
        TaxStrategy standard = new StandardTaxStrategy();
        TaxStrategy highIncome = new HighIncomeTaxStrategy();

        assertEquals(4000.0, SalaryCalculator.calculateNetPay(5000.0, standard));
        assertEquals(4200.0, SalaryCalculator.calculateNetPay(6000.0, highIncome));
        assertThrows(IllegalArgumentException.class, () -> SalaryCalculator.calculateNetPay(-100.0, standard));
    }

    @Test
    void shouldAutoSelectStrategy() {
        assertTrue(SalaryCalculator.getStrategyForSalary(3000.0) instanceof StandardTaxStrategy);
        assertTrue(SalaryCalculator.getStrategyForSalary(6000.0) instanceof HighIncomeTaxStrategy);
    }
}
