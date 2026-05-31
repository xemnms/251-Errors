package com.app.controller;

import com.app.dto.OrderItemRequest;
import com.app.dto.OrderRequest;
import com.app.dto.OrderResponse;
import com.app.entity.OrderStatus;
import com.app.exception.OrderNotFoundException;
import com.app.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// GRASP: Controller - verifying the controller only handles HTTP and delegates to service
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // GRASP: Low Coupling - mock the service so controller is tested in isolation
    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateOrderAndReturn201() throws Exception {
        // Arrange
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));

        OrderResponse response = new OrderResponse(1L, "Vic Andrew Dizon",
                OrderStatus.PENDING, 999.99, LocalDateTime.now());

        when(orderService.createOrder(any(OrderRequest.class))).thenReturn(response);

        // Act & Assert
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Vic Andrew Dizon"))
                .andExpect(jsonPath("$.total").value(999.99))
                .andExpect(jsonPath("$.status").value("PENDING"));
    }

    @Test
    void shouldGetAllOrdersAndReturn200() throws Exception {
        // Arrange
        List<OrderResponse> orders = List.of(
                new OrderResponse(1L, "Vic Andrew Dizon", OrderStatus.PENDING, 100.0, LocalDateTime.now()),
                new OrderResponse(2L, "Jane Doe", OrderStatus.PROCESSING, 200.0, LocalDateTime.now())
        );
        when(orderService.getAllOrders()).thenReturn(orders);

        // Act & Assert
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void shouldGetOrderByIdAndReturn200() throws Exception {
        // Arrange
        OrderResponse response = new OrderResponse(1L, "Vic Andrew Dizon",
                OrderStatus.PENDING, 500.0, LocalDateTime.now());
        when(orderService.getOrderById(1L)).thenReturn(response);

        // Act & Assert
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Vic Andrew Dizon"));
    }

    // GRASP: Protected Variations - test that exception handling doesn't leak internals
    @Test
    void shouldReturn404WhenOrderNotFound() throws Exception {
        // Arrange
        when(orderService.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));

        // Act & Assert
        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    void shouldReturnEmptyListWhenNoOrders() throws Exception {
        // Arrange (edge case: empty list)
        when(orderService.getAllOrders()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
