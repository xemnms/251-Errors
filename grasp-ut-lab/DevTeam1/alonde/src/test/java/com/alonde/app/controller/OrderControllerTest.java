package com.alonde.app.controller;

import com.alonde.app.dto.*;
import com.alonde.app.exception.*;
import com.alonde.app.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService service;

    @Autowired
    private ObjectMapper objectMapper;

    // test: get /api/orders returns 200 OK with list

    @Test
    void shouldReturn200ForGetAll() throws Exception {
        OrderResponse r = new OrderResponse(1L, "Ana", "PAID", "CASH", 100.0);
        when(service.getAllOrders()).thenReturn(List.of(r));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").value("Ana"))
                .andExpect(jsonPath("$[0].total").value(100.0));
    }

    // test: get /api/orders/{id} - not found returns 404

    @Test
    void shouldReturn404WhenOrderMissing() throws Exception {
        when(service.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));

        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Order not found with ID: 99"));
    }

    // test: post with missing customerName returns 400

    @Test
    void shouldReturn400ForInvalidRequest() throws Exception {
        String body = """
            {
                "customerName": "",
                "paymentType": "CASH",
                "items": [{"productName": "X", "quantity": 1, "unitPrice": 10.0}]
            }
            """;

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // test: delete returns 204 No Content on success

    @Test
    void shouldReturn204OnDelete() throws Exception {
        doNothing().when(service).deleteOrder(1L);

        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent());
    }
}
