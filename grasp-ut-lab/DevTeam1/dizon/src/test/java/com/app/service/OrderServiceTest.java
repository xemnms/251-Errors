package com.app.service;

import com.app.dto.OrderItemRequest;
import com.app.dto.OrderRequest;
import com.app.dto.OrderResponse;
import com.app.entity.Order;
import com.app.entity.OrderItem;
import com.app.entity.OrderStatus;
import com.app.exception.OrderNotFoundException;
import com.app.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// GRASP: Pure Fabrication - testing the service layer in isolation using Mockito
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    // GRASP: Low Coupling - InjectMocks wires the service with mocked repository (no DB)
    @InjectMocks
    private OrderService orderService;

    // Test 1: Create order successfully
    @Test
    void shouldCreateOrder() {
        // Arrange
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));

        Order savedOrder = new Order("Vic Andrew Dizon");
        savedOrder.setId(1L);
        savedOrder.addItem(new OrderItem("Laptop", 999.99, 1));

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // Act
        OrderResponse response = orderService.createOrder(request);

        // Assert
        assertNotNull(response);
        assertEquals("Vic Andrew Dizon", response.getCustomerName());
        assertEquals(999.99, response.getTotal());
        assertEquals(OrderStatus.PENDING, response.getStatus());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // Test 2: Get all orders returns full list
    @Test
    void shouldGetAllOrders() {
        // Arrange
        Order order1 = new Order("Vic Andrew Dizon");
        order1.setId(1L);
        Order order2 = new Order("Jane Doe");
        order2.setId(2L);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        // Act
        List<OrderResponse> result = orderService.getAllOrders();

        // Assert
        assertEquals(2, result.size());
        verify(orderRepository, times(1)).findAll();
    }

    // Test 3: Get order by id returns correct order
    @Test
    void shouldGetOrderById() {
        // Arrange
        Order order = new Order("Vic Andrew Dizon");
        order.setId(1L);
        order.addItem(new OrderItem("Phone", 500.00, 2));

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        // Act
        OrderResponse response = orderService.getOrderById(1L);

        // Assert
        assertNotNull(response);
        assertEquals("Vic Andrew Dizon", response.getCustomerName());
        // GRASP: Information Expert - Order calculates total from its own items
        assertEquals(1000.00, response.getTotal());
    }

    // Test 4: Get order by non-existent id throws exception
    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        // Arrange
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
        verify(orderRepository, times(1)).findById(99L);
    }

    // Test 5: Delete order successfully
    @Test
    void shouldDeleteOrder() {
        // Arrange
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        // Act
        orderService.deleteOrder(1L);

        // Assert
        verify(orderRepository, times(1)).deleteById(1L);
    }

    // Test 6: Return empty list when no orders exist (edge case)
    @Test
    void shouldReturnEmptyListWhenNoOrders() {
        // Arrange
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<OrderResponse> result = orderService.getAllOrders();

        // Assert
        assertTrue(result.isEmpty());
        verify(orderRepository, times(1)).findAll();
    }

    // Test 7: Blank customer name throws exception (invalid input edge case)
    @Test
    void shouldThrowWhenCustomerNameIsBlank() {
        // Arrange
        OrderRequest request = new OrderRequest("", List.of());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    // Test 8: Null customer name throws exception (null value edge case)
    @Test
    void shouldThrowWhenCustomerNameIsNull() {
        // Arrange
        OrderRequest request = new OrderRequest(null, List.of());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    // Test 9: Delete non-existent order throws exception
    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        // Arrange
        when(orderRepository.existsById(99L)).thenReturn(false);

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.deleteOrder(99L));
        verify(orderRepository, never()).deleteById(any());
    }

    // Test 10: Create order with empty items list still works
    @Test
    void shouldCreateOrderWithNoItems() {
        // Arrange
        OrderRequest request = new OrderRequest("Vic Andrew Dizon", Collections.emptyList());

        Order savedOrder = new Order("Vic Andrew Dizon");
        savedOrder.setId(1L);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // Act
        OrderResponse response = orderService.createOrder(request);

        // Assert
        assertNotNull(response);
        assertEquals(0.0, response.getTotal());
    }
}
