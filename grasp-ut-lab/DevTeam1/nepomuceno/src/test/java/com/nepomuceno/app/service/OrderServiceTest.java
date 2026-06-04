package com.nepomuceno.app.service;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;
import com.nepomuceno.app.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Uses Mockito — no real database calls at all
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CreditCardPayment creditCardPayment;

    @Mock
    private CashPayment cashPayment;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        // Re-inject with the mocked payment list
        orderService = new OrderService(
                orderRepository,
                List.of(creditCardPayment, cashPayment)
        );
    }

    // Test 1: Happy path — create a valid order
    @Test
    void shouldCreateOrderSuccessfully() {
        // Arrange
        OrderRequest request = new OrderRequest(List.of(
                new ItemDto("Coffee", 3.50, 2)
        ));
        Order mockOrder = new Order();
        mockOrder.addItem("Coffee", 3.50, 2);
        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);

        // Act
        OrderResponse response = orderService.createOrder(request);

        // Assert
        assertNotNull(response);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // Test 2: Edge case — empty item list should throw
    @Test
    void shouldThrowWhenItemListIsEmpty() {
        // Arrange
        OrderRequest request = new OrderRequest(List.of());

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    // Test 3: Edge case — null item list should throw
    @Test
    void shouldThrowWhenItemListIsNull() {
        // Arrange
        OrderRequest request = new OrderRequest(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
    }

    // Test 4: Edge case — invalid price should throw
    @Test
    void shouldThrowWhenItemHasNegativePrice() {
        // Arrange
        OrderRequest request = new OrderRequest(List.of(
                new ItemDto("Broken Item", -5.0, 1)
        ));

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
    }

    // Test 5: Order not found should throw
    @Test
    void shouldThrowWhenOrderNotFound() {
        // Arrange
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class,
                () -> orderService.getOrder(99L));
    }

    // Test 6: Polymorphism — correct payment implementation is called
    @Test
    void shouldCallCorrectPaymentImplementation() {
        // Arrange
        Order order = new Order();
        order.addItem("Burger", 5.0, 1);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any())).thenReturn(order);
        when(creditCardPayment.getType()).thenReturn("CREDIT_CARD");

        // Act
        orderService.processPayment(1L, "CREDIT_CARD");

        // Assert — CreditCardPayment.process() was called, CashPayment was NOT
        verify(creditCardPayment, times(1)).process(order);
        verify(cashPayment, never()).process(any());
    }

    // Test 7: Unknown payment type should throw
    @Test
    void shouldThrowWhenPaymentTypeUnknown() {
        // Arrange
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(creditCardPayment.getType()).thenReturn("CREDIT_CARD");
        when(cashPayment.getType()).thenReturn("CASH");

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> orderService.processPayment(1L, "BITCOIN"));
    }
}