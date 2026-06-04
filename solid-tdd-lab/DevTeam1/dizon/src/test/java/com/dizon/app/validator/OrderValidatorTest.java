package com.dizon.app.validator;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderRequest;
import com.dizon.app.exception.InvalidOrderException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the extracted validation rules (SRP). No mocks needed - the validator
 * is pure logic, which is itself a sign of a clean, single-responsibility class.
 */
class OrderValidatorTest {

    private final OrderValidator validator = new OrderValidatorImpl();

    @Test
    void shouldPass_forValidOrder() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));

        assertDoesNotThrow(() -> validator.validate(request));
    }

    // Edge cases: null AND blank customer names (BONUS: parameterized test).
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void shouldThrow_whenCustomerNameMissing(String badName) {
        OrderRequest request = new OrderRequest(badName, List.of());

        assertThrows(InvalidOrderException.class, () -> validator.validate(request));
    }

    @Test
    void shouldThrow_whenNullRequest() {
        assertThrows(InvalidOrderException.class, () -> validator.validate(null));
    }

    // Edge case: invalid input - negative price.
    @Test
    void shouldThrow_whenItemPriceNegative() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", -1.0, 1)));

        InvalidOrderException ex = assertThrows(InvalidOrderException.class,
                () -> validator.validate(request));
        assertTrue(ex.getMessage().contains("Price"));
    }

    // Edge case: invalid input - non-positive quantities (BONUS: parameterized test).
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void shouldThrow_whenItemQuantityNotPositive(int badQty) {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 10.0, badQty)));

        assertThrows(InvalidOrderException.class, () -> validator.validate(request));
    }

    @Test
    void shouldThrow_whenItemProductNameBlank() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("  ", 10.0, 1)));

        assertThrows(InvalidOrderException.class, () -> validator.validate(request));
    }
}
