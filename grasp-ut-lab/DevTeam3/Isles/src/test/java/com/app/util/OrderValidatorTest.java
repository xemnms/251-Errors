package com.app.util;

import com.app.dto.CreateOrderRequest;
import com.app.dto.OrderItemRequest;
import com.app.exception.InvalidOrderException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderValidatorTest {

    private final OrderValidator validator = new OrderValidator();

    @Test
    void shouldAcceptValidRequest() {
        CreateOrderRequest request = new CreateOrderRequest(
                "Avi Cohen",
                "PAYPAL",
                List.of(new OrderItemRequest("Monitor", 1, 250.0)));

        assertThatCode(() -> validator.validate(request)).doesNotThrowAnyException();
    }

    @Test
    void shouldRejectNullItem() {
        CreateOrderRequest request = new CreateOrderRequest("Avi Cohen", "PAYPAL", java.util.Arrays.asList((OrderItemRequest) null));

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Order item is required");
    }

    @Test
    void shouldRejectBlankCustomerName() {
        CreateOrderRequest request = new CreateOrderRequest(
                " ",
                "PAYPAL",
                List.of(new OrderItemRequest("Monitor", 1, 250.0)));

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Customer name is required");
    }
}
