package com.alonde.app.integration;

import com.alonde.app.dto.*;
import com.alonde.app.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.*;

// @SpringBootTest loads the full application context (uses H2 via test/resources/application.properties)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderIntegrationTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private OrderRepository orderRepository;

    @BeforeEach
    void cleanUp() {
        orderRepository.deleteAll();
    }

    // integration test 1: full create-then-fetch cycle
    @Test
    @Order(1)
    void createAndFetchOrder() throws Exception {
        String body = buildRequestJson("Juan dela Cruz", "CASH");

        // post - create the order
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Juan dela Cruz"))
                .andExpect(jsonPath("$.total").value(500.0));

        // get - verify it was persisted
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    // integration test 2: cancel changes status in DB
    @Test
    @Order(2)
    void cancelOrderChangesStatusInDatabase() throws Exception {
        // create first
        String createBody = buildRequestJson("Rizal", "GCASH");
        String createResponse = mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON).content(createBody))
                .andReturn().getResponse().getContentAsString();

        Long id = objectMapper.readTree(createResponse).get("id").asLong();

        // cancel it
        mockMvc.perform(patch("/api/orders/" + id + "/cancel"))
                .andExpect(status().isNoContent());

        // verify DB status
        assertThat(orderRepository.findById(id))
                .isPresent()
                .get()
                .extracting(o -> o.getStatus())
                .isEqualTo("CANCELLED");
    }

    private String buildRequestJson(String customer, String payType) throws Exception {
        OrderItemRequest item = new OrderItemRequest();
        item.setProductName("Notebook"); item.setQuantity(5); item.setUnitPrice(100.0);

        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName(customer); req.setPaymentType(payType);
        req.setItems(List.of(item));
        return objectMapper.writeValueAsString(req);
    }
}
