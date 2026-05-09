package com.app.alvarez.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyRounderTest {

    @Test
    void shouldRoundToCurrencyScale() {
        assertEquals(12.35, MoneyRounder.toCurrency(12.345));
    }
}