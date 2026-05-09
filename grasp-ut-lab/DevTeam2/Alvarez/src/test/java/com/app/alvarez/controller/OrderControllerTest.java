package com.app.alvarez.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.alvarez.entity.Order;
import com.app.alvarez.entity.OrderItem;
import com.app.alvarez.entity.PaymentMethod;
import com.app.alvarez.exception.OrderNotFoundException;
import com.app.alvarez.service.OrderUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {


    private MockMvc mockMvc;

        @Mock
    private OrderUseCase orderUseCase;

     @BeforeEach
    void setUp() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();
        mockMvc = MockMvcBuilders
                .standaloneSetup(new OrderController(orderUseCase))
                .setControllerAdvice(new ApiExceptionHandler())
                .setValidator(validator)
                .build();
    }

    @Test
    void shouldCreateOrderThroughApi() throws Exception {
        Order order = sampleOrder();
        ReflectionTestUtils.setField(order, "id", 5L);
        when(orderUseCase.createOrder(any())).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "customerName": "Ada Lovelace",
                                  "items": [
                                    { "productName": "Keyboard", "quantity": 1, "unitPrice": 19.99 }
                                  ]
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.customerName").value("Ada Lovelace"))
                .andExpect(jsonPath("$.total").value(19.99));
    }

    @Test
    void shouldReturnOrderThroughApi() throws Exception {
        Order order = sampleOrder();
        ReflectionTestUtils.setField(order, "id", 5L);
         when(orderUseCase.getOrder(5L)).thenReturn(order);

        mockMvc.perform(get("/api/orders/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.items[0].productName").value("Keyboard"));
    }

    @Test
    void shouldPayOrderThroughApi() throws Exception {
        Order order = sampleOrder();
        order.markPaid();
        ReflectionTestUtils.setField(order, "id", 5L);
        when(orderUseCase.payOrder(5L, PaymentMethod.CARD)).thenReturn(order);

        mockMvc.perform(post("/api/orders/5/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"method\":\"CARD\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("PAID"));
    }

    @Test
    void shouldReturnNotFoundForMissingOrder() throws Exception {
        when(orderUseCase.getOrder(404L)).thenThrow(new OrderNotFoundException(404L));

        mockMvc.perform(get("/api/orders/404"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Order not found: 404"));
    }

    @Test
    void shouldRejectInvalidCreatePayload() throws Exception {
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerName\":\"\",\"items\":[]}"))
                .andExpect(status().isBadRequest());
    }

    private Order sampleOrder() {
        return Order.createWithItems(
                "Ada Lovelace",
                java.util.List.of(new OrderItem("Keyboard", 1, 19.99))
        );
    }
}