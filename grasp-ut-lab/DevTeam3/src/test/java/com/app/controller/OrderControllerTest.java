package com.app.controller;

import com.app.dto.OrderItemResponse;
import com.app.dto.OrderResponse;
import com.app.exception.InvalidOrderException;
import com.app.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @Test
    void shouldCreateOrderThroughApi() throws Exception {
        OrderResponse response = new OrderResponse(
                1L,
                "Avi Cohen",
                List.of(new OrderItemResponse("Keyboard", 2, 10.0, 20.0)),
                20.0);
        when(orderService.createOrder(any())).thenReturn(response);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "customerName": "Avi Cohen",
                                  "paymentMethod": "CREDIT_CARD",
                                  "items": [
                                    {"productName": "Keyboard", "quantity": 2, "unitPrice": 10.0}
                                  ]
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Avi Cohen"))
                .andExpect(jsonPath("$.total").value(20.0));
    }

    @Test
    void shouldReturnBadRequestForInvalidOrder() throws Exception {
        when(orderService.createOrder(any())).thenThrow(new InvalidOrderException("Order must contain at least one item"));

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "customerName": "Avi Cohen",
                                  "paymentMethod": "CREDIT_CARD",
                                  "items": []
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Order must contain at least one item"));
    }

    @Test
    void shouldGetOrderThroughApi() throws Exception {
        OrderResponse response = new OrderResponse(5L, "Avi Cohen", List.of(), 0.0);
        when(orderService.getOrder(5L)).thenReturn(response);

        mockMvc.perform(get("/orders/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.customerName").value("Avi Cohen"));
    }
}
