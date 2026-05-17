package com.app.costiniano.controller;

import com.app.costiniano.dto.OrderRequestDto;
import com.app.costiniano.dto.OrderResponseDto;
import com.app.costiniano.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Pure Native Java Subclass Mock to completely bypass Java 25 Mockito/ByteBuddy limitations
    private static class MockOrderService extends OrderService {
        public MockOrderService() {
            super(null, List.of()); // Pass nulls since we are overriding the checkout logic completely
        }

        @Override
        public OrderResponseDto checkout(OrderRequestDto request) {
            return new OrderResponseDto(1L, 500.0, "PAID_VIA_CARD");
        }
    }

    @BeforeEach
    void setUp() {
        OrderService mockService = new MockOrderService();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(mockService))
                .setControllerAdvice(new com.app.costiniano.exception.GlobalExceptionHandler())
                .build();
    }

    @Test
    void controllerShouldReturnOk_WhenRequestIsValid() throws Exception {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(Collections.emptyList(), "CARD");

        // Act & Assert
        mockMvc.perform(post("/api/orders/checkout")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.status").value("PAID_VIA_CARD"))
                .andExpect(jsonPath("$.totalAmount").value(500.0));
    }
}