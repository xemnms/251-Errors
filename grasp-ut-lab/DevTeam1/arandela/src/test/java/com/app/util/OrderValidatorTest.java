package com.app.util;

import com.app.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    OrderValidator validator = new OrderValidatorImpl();

    @Test
    void shouldReturnTrueForValidDto() {
        assertTrue(validator.isValid(new OrderDTO("Juan", "CASH")));
    }

    @Test
    void shouldReturnFalseForNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalseForBlankName() {
        assertFalse(validator.isValid(new OrderDTO("  ", "CASH")));
    }

    @Test
    void shouldReturnFalseForNullPayment() {
        assertFalse(validator.isValid(new OrderDTO("Juan", null)));
    }

    @Test
    void shouldReturnFalseForBlankPayment() {
        assertFalse(validator.isValid(new OrderDTO("Juan", "  ")));
    }
}
