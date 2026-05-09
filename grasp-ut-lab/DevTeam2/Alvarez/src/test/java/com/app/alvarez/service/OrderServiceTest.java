package com.app.alvarez.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.alvarez.dto.CreateOrderRequest;
import com.app.alvarez.dto.OrderItemRequest;
import com.app.alvarez.entity.Order;
import com.app.alvarez.entity.OrderStatus;
import com.app.alvarez.entity.PaymentMethod;
import com.app.alvarez.exception.InvalidOrderException;
import com.app.alvarez.exception.OrderNotFoundException;
import com.app.alvarez.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private PaymentProcessorResolver paymentProcessorResolver;

    @Mock
    private PaymentProcessor paymentProcessor;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderRepository, paymentProcessorResolver, new OrderRequestValidator());
    }

    @Test
    void shouldCreateOrder() {
        CreateOrderRequest request = validRequest();
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order result = orderService.createOrder(request);

        assertEquals("Ada Lovelace", result.getCustomerName());
        assertEquals(OrderStatus.CREATED, result.getStatus());
        assertEquals(2, result.getItems().size());
        assertEquals(39.97, result.calculateTotal(), 0.001);
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void shouldRejectEmptyItemList() {
        CreateOrderRequest request = new CreateOrderRequest("Ada Lovelace", List.of());

        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(request));

        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void shouldRejectNullRequest() {
        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(null));

        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void shouldRejectInvalidItemQuantity() {
        CreateOrderRequest request = new CreateOrderRequest(
                "Ada Lovelace",
                List.of(new OrderItemRequest("Keyboard", 0, 19.99))
        );

        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(request));

        verify(orderRepository, never()).save(any(Order.class));
    }

    @Test
    void shouldReturnExistingOrder() {
        Order order = sampleOrder();
        when(orderRepository.findById(7L)).thenReturn(Optional.of(order));

        Order result = orderService.getOrder(7L);

        assertEquals(order, result);
    }

    @Test
    void shouldThrowWhenOrderDoesNotExist() {
        when(orderRepository.findById(404L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrder(404L));
    }

    @Test
    void shouldProcessPaymentAndMarkOrderPaid() {
        Order order = sampleOrder();
        when(orderRepository.findById(7L)).thenReturn(Optional.of(order));
        when(paymentProcessorResolver.resolve(PaymentMethod.CARD)).thenReturn(paymentProcessor);
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order result = orderService.payOrder(7L, PaymentMethod.CARD);

        assertEquals(OrderStatus.PAID, result.getStatus());
        verify(paymentProcessor).process(39.97);
        verify(orderRepository).save(order);
    }

    @Test
    void shouldKeepOrderUnpaidWhenPaymentFails() {
        Order order = sampleOrder();
        when(orderRepository.findById(7L)).thenReturn(Optional.of(order));
        when(paymentProcessorResolver.resolve(PaymentMethod.CARD)).thenReturn(paymentProcessor);
        org.mockito.Mockito.doThrow(new IllegalArgumentException("declined"))
                .when(paymentProcessor)
                .process(39.97);

        assertThrows(IllegalArgumentException.class, () -> orderService.payOrder(7L, PaymentMethod.CARD));

       assertEquals(OrderStatus.CREATED, order.getStatus());
        verify(orderRepository, never()).save(order);
    }

    private CreateOrderRequest validRequest() {
        return new CreateOrderRequest(
                "Ada Lovelace",
                List.of(
                        new OrderItemRequest("Keyboard", 1, 19.99),
                        new OrderItemRequest("Mouse", 2, 9.99)
                )
        );
    }

    private Order sampleOrder() {
         return Order.createWithItems(
                "Ada Lovelace",
                List.of(
                        new com.app.alvarez.entity.OrderItem("Keyboard", 1, 19.99),
                        new com.app.alvarez.entity.OrderItem("Mouse", 2, 9.99)
                )
        );
    }
}