package com.nepomuceno.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// GRASP: Controller test — verifies HTTP layer behavior only; service is mocked
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    // Test 1: POST /api/orders returns 200 with valid request
    @Test
    void shouldReturn200WhenOrderCreated() throws Exception {
        // Arrange
        OrderRequest request = new OrderRequest(List.of(
                new ItemDto("Coffee", 3.50, 2)
        ));
        OrderResponse response = new OrderResponse(1L, "PENDING", 7.0, "PHP 7.00");
        when(orderService.createOrder(any(OrderRequest.class))).thenReturn(response);

        // Act & Assert
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.status").value("PENDING"))
                .andExpect(jsonPath("$.formattedTotal").value("PHP 7.00"));
    }

    // Test 2: GET /api/orders/{id} returns 200 when found
    @Test
    void shouldReturn200WhenOrderFound() throws Exception {
        // Arrange
        OrderResponse response = new OrderResponse(1L, "PENDING", 7.0, "PHP 7.00");
        when(orderService.getOrder(1L)).thenReturn(response);

        // Act & Assert
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    // Test 3: GET /api/orders/{id} returns 404 when not found
    @Test
    void shouldReturn404WhenOrderNotFound() throws Exception {
        // Arrange
        when(orderService.getOrder(99L))
                .thenThrow(new NoSuchElementException("Order not found: 99"));

        // Act & Assert
        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound());
    }

    // Test 4: POST /api/orders with empty items returns 400
    @Test
    void shouldReturn400WhenItemsEmpty() throws Exception {
        // Arrange
        OrderRequest request = new OrderRequest(List.of());
        when(orderService.createOrder(any()))
                .thenThrow(new IllegalArgumentException("Order must have at least one item."));

        // Act & Assert
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}