package com.nepomuceno.app.mapper;

import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;
import com.nepomuceno.app.util.PriceFormatter;
import org.springframework.stereotype.Component;

// SOLID: SRP - only responsible for mapping Order → OrderResponse
// SOLID: OCP - new response shapes can be added by creating a new mapper, not editing this one
// SOLID: DIP - implements the OrderMapper abstraction; callers never reference this class directly
//
// BEFORE (mapping was inside OrderService, mixed with business logic):
//   private OrderResponse toResponse(Order order) {
//       double total = order.calculateTotal();
//       return new OrderResponse(order.getId(), order.getStatus(),
//                                total, PriceFormatter.format(total));
//   }
//
// AFTER (extracted to its own class):
//   OrderService only calls orderMapper.toResponse(order)
//   All mapping knowledge lives here and nowhere else
@Component
public class OrderMapperImpl implements OrderMapper {

    // SOLID: SRP - single job: turn an Order into an OrderResponse
    @Override
    public OrderResponse toResponse(Order order) {
        double total = order.calculateTotal();
        return new OrderResponse(
                order.getId(),
                order.getStatus(),
                total,
                PriceFormatter.format(total)
        );
    }
}
