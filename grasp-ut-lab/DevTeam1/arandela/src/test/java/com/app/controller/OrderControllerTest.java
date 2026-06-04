package com.app.controller;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.service.OrderService;
import com.app.util.OrderNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// GRASP: Controller - verifies controller delegates to service correctly
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock OrderService orderService;
    @InjectMocks OrderController orderController;

    @Test
    void shouldCreateOrderAndReturn200() {
        OrderDTO dto = new OrderDTO("Juan", "CASH");
        when(orderService.createOrder(any(OrderDTO.class))).thenReturn(new Order("Juan"));
        ResponseEntity<Order> response = orderController.createOrder(dto);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Juan", response.getBody().getCustomerName());
    }

    @Test
    void shouldGetAllOrders() {
        when(orderService.getAllOrders()).thenReturn(List.of(new Order("Ana"), new Order("Ben")));
        ResponseEntity<List<Order>> response = orderController.getAllOrders();
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderService.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));
        assertThrows(OrderNotFoundException.class, () -> orderController.getOrder(99L));
    }
}
