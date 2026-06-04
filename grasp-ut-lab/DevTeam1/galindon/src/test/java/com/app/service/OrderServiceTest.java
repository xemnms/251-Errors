package com.app.service;

import com.app.entity.Order;
import com.app.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository repository;

    @InjectMocks
    OrderService service;

    @Test
    void shouldCreateOrder() {

        Order order = new Order();

        when(repository.save(order))
                .thenReturn(order);

        Order result =
                service.createOrder(order);

        assertNotNull(result);

        verify(repository).save(order);
    }

    @Test
    void shouldThrowExceptionForNullOrder() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createOrder(null)
        );
    }

    @Test
    void shouldReturnAllOrders() {

        when(repository.findAll())
                .thenReturn(List.of(
                        new Order(),
                        new Order()
                ));

        assertEquals(
                2,
                service.getAllOrders().size()
        );
    }

    @Test
    void shouldReturnOrderById() {

        Order order = new Order();

        when(repository.findById(1L))
                .thenReturn(Optional.of(order));

        assertNotNull(
                service.getOrder(1L)
        );
    }

    @Test
    void shouldThrowWhenOrderNotFound() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> service.getOrder(1L)
        );
    }
}