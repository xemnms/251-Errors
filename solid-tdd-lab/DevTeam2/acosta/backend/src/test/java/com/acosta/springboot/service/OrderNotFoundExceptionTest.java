package com.acosta.springboot.service;

import com.acosta.springboot.exception.OrderNotFoundException;
import com.acosta.springboot.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// SOLID: SRP - Tests only the custom exception behavior
@ExtendWith(MockitoExtension.class)
class OrderNotFoundExceptionTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    PaymentProcessorFactory paymentProcessorFactory;

    @Mock
    OrderValidator orderValidator;

    @InjectMocks
    OrderService orderService;

    // =========================================================
    // TEST 1: getOrderById throws OrderNotFoundException
    // =========================================================
    @Test
    void shouldThrowOrderNotFoundExceptionWhenOrderMissing() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Must throw OUR custom exception, not a generic RuntimeException
        assertThrows(OrderNotFoundException.class, () -> {
            orderService.getOrderById(99L);
        });
    }

    // =========================================================
    // TEST 2: deleteOrder throws OrderNotFoundException
    // =========================================================
    @Test
    void shouldThrowOrderNotFoundExceptionWhenDeletingMissingOrder() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        assertThrows(OrderNotFoundException.class, () -> {
            orderService.deleteOrder(99L);
        });
    }

    // =========================================================
    // TEST 3: Exception message contains the missing ID
    // =========================================================
    @Test
    void shouldIncludeOrderIdInExceptionMessage() {
        when(orderRepository.findById(42L)).thenReturn(Optional.empty());

        OrderNotFoundException ex = assertThrows(OrderNotFoundException.class, () -> {
            orderService.getOrderById(42L);
        });

        // KISS: Clear error message tells you exactly what went wrong
        assertTrue(ex.getMessage().contains("42"));
    }
}