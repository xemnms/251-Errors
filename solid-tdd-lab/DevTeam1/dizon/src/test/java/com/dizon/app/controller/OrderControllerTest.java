package com.dizon.app.controller;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderRequest;
import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.OrderStatus;
import com.dizon.app.exception.OrderNotFoundException;
import com.dizon.app.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Web-layer tests with the service MOCKED (@MockBean) - confirms the controller is a thin
 * HTTP adapter that only delegates, and that immutable record DTOs serialize/deserialize.
 */
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean private OrderService orderService;

    @Test
    void shouldCreateOrderAndReturn201() throws Exception {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));
        OrderResponse response = new OrderResponse(1L, "Vic Andrew Dizon",
                OrderStatus.PENDING, 999.99, LocalDateTime.now(), List.of());
        when(orderService.createOrder(any(OrderRequest.class))).thenReturn(response);

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
        when(orderService.getAllOrders()).thenReturn(List.of(
                new OrderResponse(1L, "A", OrderStatus.PENDING, 100.0, LocalDateTime.now(), List.of()),
                new OrderResponse(2L, "B", OrderStatus.PROCESSING, 200.0, LocalDateTime.now(), List.of())
        ));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void shouldGetOrderByIdAndReturn200() throws Exception {
        when(orderService.getOrderById(1L)).thenReturn(
                new OrderResponse(1L, "Vic Andrew Dizon", OrderStatus.PENDING, 500.0, LocalDateTime.now(), List.of()));

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Vic Andrew Dizon"));
    }

    // Verifies GlobalExceptionHandler maps the custom exception to 404 without leaking internals.
    @Test
    void shouldReturn404WhenOrderNotFound() throws Exception {
        when(orderService.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));

        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").exists());
    }
}
