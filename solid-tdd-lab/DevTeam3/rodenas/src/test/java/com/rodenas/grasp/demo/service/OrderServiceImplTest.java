package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import com.rodenas.grasp.demo.entity.Order;
import com.rodenas.grasp.demo.entity.OrderItem;
import com.rodenas.grasp.demo.exception.OrderNotFoundException;
import com.rodenas.grasp.demo.payment.PaymentProcessor;
import com.rodenas.grasp.demo.repository.OrderRepository;
import com.rodenas.grasp.demo.util.PriceCalculator;
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
class OrderServiceImplTest {

    @Mock OrderRepository orderRepository;
    @Mock OrderValidator orderValidator;
    @Mock PriceCalculator priceCalculator;
    @Mock PaymentProcessor cashProcessor;
    @Mock PaymentProcessor gcashProcessor;

    private OrderServiceImpl orderService;
    private OrderRequestDTO validRequest;
    private Order order;

    @BeforeEach
    void setUp() {
        when(cashProcessor.getPaymentMethod()).thenReturn("CASH");
        when(gcashProcessor.getPaymentMethod()).thenReturn("GCASH");

        orderService = new OrderServiceImpl(
                orderRepository,
                orderValidator,
                priceCalculator,
                List.of(cashProcessor, gcashProcessor)
        );

        validRequest = new OrderRequestDTO(
                "Kyla Rodenas",
                "CASH",
                List.of(new OrderItemDTO("Burger", 120.0, 2))
        );

        order = new Order("Kyla Rodenas", "CASH");
        order.addItem(new OrderItem("Burger", 120.0, 2));
    }

    @Test
    void shouldCallValidatorOnCreate() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(cashProcessor.process(anyDouble())).thenReturn(true);

        orderService.createOrder(validRequest);

        verify(orderValidator, times(1)).validate(validRequest);
    }

    @Test
    void shouldSaveOrderAndProcessCashPayment() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(cashProcessor.process(240.0)).thenReturn(true);

        Order saved = orderService.createOrder(validRequest);

        assertEquals("Kyla Rodenas", saved.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
        verify(cashProcessor, times(1)).process(240.0);
    }

    @Test
    void shouldReturnTotalWithVat() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(priceCalculator.calculateTotalWithVat(order)).thenReturn(268.8);

        double total = orderService.getOrderTotalWithVat(1L);

        assertEquals(268.8, total);
    }

    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    @Test
    void shouldUpdateStatus() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(order)).thenReturn(order);

        Order updated = orderService.updateOrderStatus(1L, "DONE");

        assertEquals("DONE", updated.getStatus());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void shouldDeleteOrderWhenExists() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).delete(order);
    }

    @Test
    void shouldHandleNullOrderRequest() {
        doThrow(new IllegalArgumentException("Order request cannot be null")).when(orderValidator).validate(null);

        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(null));
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldReturnEmptyListWhenNoOrders() {
        when(orderRepository.findAll()).thenReturn(List.of());

        assertTrue(orderService.getAllOrders().isEmpty());
    }
}
