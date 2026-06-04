package com.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxStrategyTest {

    @Test
    void testStandardTaxStrategy() {
        TaxStrategy strategy = new StandardTaxStrategy();
        assertEquals(1000.0, strategy.calculateTax(5000.0));
        assertThrows(IllegalArgumentException.class, () -> strategy.calculateTax(-100.0));
    }

    @Test
    void testHighIncomeTaxStrategy() {
        TaxStrategy strategy = new HighIncomeTaxStrategy();
        assertEquals(1800.0, strategy.calculateTax(6000.0));
        assertThrows(IllegalArgumentException.class, () -> strategy.calculateTax(-100.0));
    }

    // SOLID: LSP Verification — Proves both strategies can be used interchangeably in client code without changing state expectations or throwing unexpected error formats.
    @Test
    void testLiskovSubstitutionPrinciple() {
        TaxStrategy standard = new StandardTaxStrategy();
        TaxStrategy highIncome = new HighIncomeTaxStrategy();

        // Standard can be substituted where TaxStrategy is expected
        executeStrategyCommonAssertions(standard, 1000.0, 200.0);
        
        // HighIncome can also be substituted in the same assertion workflow
        executeStrategyCommonAssertions(highIncome, 1500.0, 300.0);
    }

    private void executeStrategyCommonAssertions(TaxStrategy strategy, double expectedTaxFor5000, double expectedTaxFor1000) {
        assertEquals(expectedTaxFor5000, strategy.calculateTax(5000.0));
        assertEquals(expectedTaxFor1000, strategy.calculateTax(1000.0));
        assertThrows(IllegalArgumentException.class, () -> strategy.calculateTax(-50.0));
    }
}
