package com.app.alvarez.util;

import com.app.alvarez.dto.OrderItemResponse;
import com.app.alvarez.dto.OrderResponse;
import com.app.alvarez.entity.Order;
import com.app.alvarez.entity.OrderItem;
import java.util.List;

public final class OrderMapper {

    private OrderMapper() {
    }

    public static OrderResponse toResponse(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
                .map(OrderMapper::toItemResponse)
                .toList();
        return new OrderResponse(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                items,
                MoneyRounder.toCurrency(order.calculateTotal())
        );
    }

    // GRASP: Pure Fabrication - mapping is placed in a utility so entities stay focused on domain behavior.
    private static OrderItemResponse toItemResponse(OrderItem item) {
        return new OrderItemResponse(
                item.getProductName(),
                item.getQuantity(),
                item.getUnitPrice(),
                MoneyRounder.toCurrency(item.calculateSubtotal())
        );
    }
}