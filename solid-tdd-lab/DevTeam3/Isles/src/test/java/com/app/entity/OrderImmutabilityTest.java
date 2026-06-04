package com.app.entity;

import com.app.dto.OrderItemResponse;
import com.app.dto.OrderResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderImmutabilityTest {

    @Test
    void orderItemsCannotBeModifiedFromGetter() {
        Order order = new Order("Avi Cohen");
        order.addItem("Keyboard", 1, 100.0);

        assertThatThrownBy(() -> order.getItems().add(new OrderItem("Mouse", 1, 10.0, order)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(order.getItems()).hasSize(1);
    }

    @Test
    void orderResponseDefensivelyCopiesItems() {
        List<OrderItemResponse> sourceItems = new ArrayList<>();
        sourceItems.add(new OrderItemResponse("Keyboard", 1, 100.0, 100.0));

        OrderResponse response = new OrderResponse(1L, "Avi Cohen", sourceItems, 100.0);
        sourceItems.clear();

        assertThat(response.items()).hasSize(1);
        assertThatThrownBy(() -> response.items().add(new OrderItemResponse("Mouse", 1, 10.0, 10.0)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
