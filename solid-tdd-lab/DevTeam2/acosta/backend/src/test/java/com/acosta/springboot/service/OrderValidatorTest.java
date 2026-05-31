package com.acosta.springboot.service;
import com.acosta.springboot.dto.OrderRequest;
import com.acosta.springboot.service.OrderValidatorImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: SRP - This test class only tests validation logic
class OrderValidatorTest {

    private OrderValidator validator;

    @BeforeEach
void setUp() {
    // SOLID: SRP - testing only the validation implementation
    validator = new OrderValidatorImpl(); // changed from new OrderValidator()
}
    // =========================================================
    // TEST 1: Null customer name should throw
    // =========================================================
    @Test
    void shouldThrowWhenCustomerNameIsNull() {
        OrderRequest request = new OrderRequest(null, List.of(), "CASH");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(request);
        });
    }

    // =========================================================
    // TEST 2: Blank customer name should throw
    // =========================================================
    @Test
    void shouldThrowWhenCustomerNameIsBlank() {
        List<OrderRequest.OrderItemRequest> items = new ArrayList<>();
        items.add(new OrderRequest.OrderItemRequest("Burger", 99.0, 1));

        OrderRequest request = new OrderRequest("   ", items, "CASH");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(request);
        });
    }

    // =========================================================
    // TEST 3: Empty item list should throw
    // =========================================================
    @Test
    void shouldThrowWhenItemListIsEmpty() {
        OrderRequest request = new OrderRequest("Juan", new ArrayList<>(), "CASH");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(request);
        });
    }

    // =========================================================
    // TEST 4: Null item list should throw
    // =========================================================
    @Test
    void shouldThrowWhenItemListIsNull() {
        OrderRequest request = new OrderRequest("Juan", null, "CASH");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(request);
        });
    }

    // =========================================================
    // TEST 5: Valid request should NOT throw anything
    // =========================================================
    @Test
    void shouldPassWhenRequestIsValid() {
        List<OrderRequest.OrderItemRequest> items = new ArrayList<>();
        items.add(new OrderRequest.OrderItemRequest("Burger", 99.0, 1));

        OrderRequest request = new OrderRequest("Juan", items, "CASH");

        // Should complete without throwing any exception
        assertDoesNotThrow(() -> validator.validate(request));
    }
}