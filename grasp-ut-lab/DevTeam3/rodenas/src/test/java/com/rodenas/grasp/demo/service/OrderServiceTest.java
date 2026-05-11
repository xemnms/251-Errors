package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import com.rodenas.grasp.demo.entity.Order;
import com.rodenas.grasp.demo.entity.OrderItem;
import com.rodenas.grasp.demo.exception.OrderNotFoundException;
import com.rodenas.grasp.demo.payment.CashPaymentProcessor;
import com.rodenas.grasp.demo.payment.GCashPaymentProcessor;
import com.rodenas.grasp.demo.payment.PaymentProcessor;
import com.rodenas.grasp.demo.repository.OrderRepository;
import com.rodenas.grasp.demo.util.PriceCalculatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    private PriceCalculatorUtil priceCalculator;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        priceCalculator = new PriceCalculatorUtil();
        List<PaymentProcessor> processors = List.of(
                new CashPaymentProcessor(),
                new GCashPaymentProcessor()
        );
        orderService = new OrderService(orderRepository, priceCalculator, processors);
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        // Arrange
        OrderRequestDTO dto = new OrderRequestDTO();
        dto.setCustomerName("Kyla");
        dto.setPaymentMethod("CASH");
        dto.setItems(List.of(new OrderItemDTO("KayBurger", 99.0, 2)));

        Order saved = new Order("Kyla", "CASH");
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        // Act
        Order result = orderService.createOrder(dto);

        // Assert
        assertNotNull(result);
        assertEquals("Kyla", result.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void shouldReturnAllOrders() {
        // Arrange
        when(orderRepository.findAll()).thenReturn(List.of(
                new Order("Kyla", "CASH"),
                new Order("Cassandra", "GCASH")
        ));

        // Act
        List<Order> result = orderService.getAllOrders();

        // Assert
        assertEquals(2, result.size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        // Arrange
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    @Test
    void shouldUpdateOrderStatus() {
        // Arrange
        Order order = new Order("Kyla", "CASH");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // Act
        Order result = orderService.updateOrderStatus(1L, "PREPARING");

        // Assert
        assertEquals("PREPARING", result.getStatus());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void shouldDeleteOrder() {
        // Arrange
        Order order = new Order("Kyla", "CASH");
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        // Act
        orderService.deleteOrder(1L);

        // Assert
        verify(orderRepository, times(1)).delete(order);
    }

    @Test
    void shouldHandleEmptyItemsOrder() {
        // Arrange - edge case: empty items
        OrderRequestDTO dto = new OrderRequestDTO();
        dto.setCustomerName("Kyla");
        dto.setPaymentMethod("CASH");
        dto.setItems(List.of());

        Order saved = new Order("Kyla", "CASH");
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        // Act
        Order result = orderService.createOrder(dto);

        // Assert
        assertNotNull(result);
        assertEquals(0.0, result.calculateTotal());
    }

    @Test
    void shouldCalculateCorrectOrderTotal() {
        // GRASP: Information Expert test - Order calculates its own total
        Order order = new Order("Kyla", "CASH");
        order.addItem(new OrderItem("KayBurger", 99.0, 2));
        order.addItem(new OrderItem("KayFries", 49.0, 1));

        assertEquals(247.0, order.calculateTotal());
    }

    @Test
    void shouldUseCorrectPaymentProcessorPolymorphically() {
        // GRASP: Polymorphism test
        OrderRequestDTO dto = new OrderRequestDTO();
        dto.setCustomerName("Kyla");
        dto.setPaymentMethod("GCASH");
        dto.setItems(List.of());

        Order saved = new Order("Kyla", "GCASH");
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        Order result = orderService.createOrder(dto);
        assertEquals("GCASH", result.getPaymentMethod());
    }
}