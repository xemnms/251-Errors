package com.dizon.app.mapper;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.Order;
import com.dizon.app.entity.OrderItem;
import com.dizon.app.util.PriceFormatter;
import org.springframework.stereotype.Component;

import java.util.List;

// SOLID: SRP - this class has ONE reason to change: how an Order becomes an OrderResponse.
//        BEFORE, this was a private `toResponse()` method tangled inside OrderService.
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(Order order) {
        List<OrderItemRequest> items = order.getItems().stream()
                .map(this::toItemDto)
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                // Information Expert preserved: Order calculates its own total.
                // DRY: rounding handled in one place by PriceFormatter.
                PriceFormatter.round(order.calculateTotal()),
                order.getCreatedAt(),
                items
        );
    }

    // DRY: single place that knows how to turn an OrderItem into its DTO.
    private OrderItemRequest toItemDto(OrderItem item) {
        return new OrderItemRequest(item.getProductName(), item.getPrice(), item.getQuantity());
    }
}
