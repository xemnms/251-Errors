package com.dizon.app.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PriceFormatterTest {

    // BONUS: parameterized test covering rounding behaviour at 2 decimal places.
    @ParameterizedTest
    @CsvSource({
            "1025.504, 1025.50",
            "1025.505, 1025.51",
            "0.0,      0.0",
            "999.999,  1000.0"
    })
    void shouldRoundToTwoDecimals(double input, double expected) {
        assertEquals(expected, PriceFormatter.round(input));
    }

    @Test
    void shouldLeaveAlreadyRoundedValueUnchanged() {
        assertEquals(50.25, PriceFormatter.round(50.25));
    }
}
