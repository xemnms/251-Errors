package com.app.service;

import com.app.entity.Order;
import com.app.payment.Payment;
import com.app.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    OrderRepository repo = mock(OrderRepository.class);
    Payment payment = mock(Payment.class);

    OrderService service = new OrderService(repo, payment);

    @Test
    void shouldCreateOrder() {
        Order order = new Order();
        when(repo.save(order)).thenReturn(order);

        Order result = service.createOrder(order);

        assertEquals(order, result);
        verify(repo).save(order);
    }

    @Test
    void shouldPayForOrder() {
        Order order = new Order();
        order.setId(1L);

        when(repo.findById(1L)).thenReturn(Optional.of(order));

        service.payForOrder(1L, 100);

        verify(payment).pay(100);
        verify(repo).save(order);
        assertTrue(order.isPaid());
    }
}