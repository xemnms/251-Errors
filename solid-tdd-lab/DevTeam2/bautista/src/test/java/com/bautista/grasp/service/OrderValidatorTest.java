package com.bautista.grasp.service;

import com.bautista.grasp.dto.OrderItemDTO;
import com.bautista.grasp.dto.OrderRequestDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// SRP proof: validates that the validator class handles all input rules independently
class OrderValidatorTest {

    // DIP: testing via interface reference, not the concrete class
    private final OrderValidator validator = new OrderValidatorImpl();

    @Test
    void shouldPassForValidRequest() {

        OrderRequestDTO request = new OrderRequestDTO(
                List.of(new OrderItemDTO(1L, 2))
        );

        assertDoesNotThrow(() -> validator.validate(request));
    }

    @Test
    void shouldThrowForNullRequest() {

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(null));
    }

    @Test
    void shouldThrowForNullItemsList() {

        OrderRequestDTO request = new OrderRequestDTO(null);

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(request));
    }

    @Test
    void shouldThrowForEmptyItemsList() {

        OrderRequestDTO request = new OrderRequestDTO(List.of());

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(request));
    }

    @Test
    void shouldThrowForZeroQuantity() {

        OrderRequestDTO request = new OrderRequestDTO(
                List.of(new OrderItemDTO(1L, 0))
        );

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(request));
    }

    @Test
    void shouldThrowForNegativeQuantity() {

        OrderRequestDTO request = new OrderRequestDTO(
                List.of(new OrderItemDTO(1L, -5))
        );

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(request));
    }
}
