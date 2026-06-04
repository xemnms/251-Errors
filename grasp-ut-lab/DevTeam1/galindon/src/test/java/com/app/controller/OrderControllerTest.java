package com.app.controller;

import com.app.entity.Order;
import com.app.service.OrderService;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Test
    void shouldCallService() {

        OrderService service =
                mock(OrderService.class);

        OrderController controller =
                new OrderController(service);

        Order order = new Order();

        controller.create(order);

        verify(service)
                .createOrder(order);
    }
}