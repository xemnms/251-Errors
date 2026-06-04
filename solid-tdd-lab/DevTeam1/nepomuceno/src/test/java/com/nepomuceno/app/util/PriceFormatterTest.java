package com.nepomuceno.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Simple unit tests for PriceFormatter — no Spring context needed
class PriceFormatterTest {

    @Test
    void shouldFormatAsPhp() {
        String result = PriceFormatter.format(7.0);
        assertEquals("PHP 7.00", result);
    }

    @Test
    void shouldFormatWithTwoDecimalPlaces() {
        String result = PriceFormatter.format(3.5);
        assertEquals("PHP 3.50", result);
    }

    @Test
    void shouldFormatZeroAmount() {
        String result = PriceFormatter.format(0.0);
        assertEquals("PHP 0.00", result);
    }

    // YAGNI: formatUSD() was removed from PriceFormatter — it was never used
    // in the codebase. The test is removed along with the method.
}