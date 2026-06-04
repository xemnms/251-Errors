package com.nepomuceno.app.service;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;
import com.nepomuceno.app.mapper.OrderMapper;
import com.nepomuceno.app.repository.OrderRepository;
import com.nepomuceno.app.validator.OrderValidator;
import com.nepomuceno.app.validator.OrderValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderMapper orderMapper;

    private CreditCardPayment creditCardPayment;
    private CashPayment cashPayment;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        creditCardPayment = mock(CreditCardPayment.class);
        cashPayment = mock(CashPayment.class);

        orderService = new OrderService(
                orderRepository,
                List.of(creditCardPayment, cashPayment),
                orderValidator,
                orderMapper
        );
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        OrderRequest request = new OrderRequest(List.of(
                new ItemDto("Coffee", 3.50, 2)
        ));
        Order mockOrder = new Order();
        mockOrder.addItem("Coffee", 3.50, 2);

        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);
        when(orderMapper.toResponse(any(Order.class)))
                .thenReturn(new OrderResponse(1L, "PENDING", 7.0, "Coffee x2"));

        OrderResponse response = orderService.createOrder(request);

        assertNotNull(response);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void shouldThrowWhenItemListIsEmpty() {
        OrderRequest request = new OrderRequest(List.of());

        // DIP: mock validator throws — proves OrderService delegates validation
        doThrow(new IllegalArgumentException("Item list must not be empty"))
                .when(orderValidator).validateRequest(request);

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldThrowWhenItemListIsNull() {
        OrderRequest request = new OrderRequest(null);

        // DIP: mock validator throws — proves OrderService delegates null check
        doThrow(new IllegalArgumentException("Item list must not be null"))
                .when(orderValidator).validateRequest(request);

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
    }

    @Test
    void shouldThrowWhenItemHasNegativePrice() {
        OrderRequest request = new OrderRequest(List.of(
                new ItemDto("Broken Item", -5.0, 1)
        ));

        // DIP: mock validator throws — proves OrderService delegates price validation
        doThrow(new IllegalArgumentException("Item price must be greater than zero"))
                .when(orderValidator).validateRequest(request);

        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(request));
    }

    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> orderService.getOrder(99L));
    }

    @Test
    void shouldCallCorrectPaymentImplementation() {
        Order order = new Order();
        order.addItem("Burger", 5.0, 1);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any())).thenReturn(order);
        when(creditCardPayment.getType()).thenReturn("CREDIT_CARD");

        orderService.processPayment(1L, "CREDIT_CARD");

        verify(creditCardPayment, times(1)).process(order);
        verify(cashPayment, never()).process(any());
    }

    @Test
    void shouldThrowWhenPaymentTypeUnknown() {
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(creditCardPayment.getType()).thenReturn("CREDIT_CARD");
        when(cashPayment.getType()).thenReturn("CASH");

        assertThrows(IllegalArgumentException.class,
                () -> orderService.processPayment(1L, "BITCOIN"));
    }

    @Test
    void validator_negativePrice_throwsForItem() {
        // Tests the REAL OrderValidatorImpl directly — not the mock
        OrderValidator validator = new OrderValidatorImpl();
        ItemDto badItem = new ItemDto("Bad", -5.0, 1);
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateItem(badItem));
    }
}