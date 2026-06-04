package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    private OrderValidatorImpl validator;

    @BeforeEach
    void setUp() {
        validator = new OrderValidatorImpl();
    }

    @Test
    void shouldAllowValidRequest() {
        OrderRequestDTO dto = new OrderRequestDTO(
                "Kyla Rodenas",
                "GCASH",
                List.of(new OrderItemDTO("Burger", 120.0, 2))
        );

        assertDoesNotThrow(() -> validator.validate(dto));
    }

    @Test
    void shouldRejectNullRequest() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
    }

    @Test
    void shouldRejectBlankCustomerName() {
        OrderRequestDTO dto = new OrderRequestDTO(" ", "CASH", List.of(new OrderItemDTO("Burger", 100.0, 1)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldRejectInvalidItemPrice() {
        OrderRequestDTO dto = new OrderRequestDTO("Kyla", "CARD", List.of(new OrderItemDTO("Burger", 0.0, 1)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(dto));
    }

    @Test
    void shouldRejectInvalidItemQuantity() {
        OrderRequestDTO dto = new OrderRequestDTO("Kyla", "CARD", List.of(new OrderItemDTO("Burger", 20.0, 0)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(dto));
    }
}
