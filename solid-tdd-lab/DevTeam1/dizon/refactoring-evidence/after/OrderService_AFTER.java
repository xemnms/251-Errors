// ===== AFTER (SOLID refactor) — src/main/java/com/dizon/app/service/OrderService.java =====
// FIX: OrderService now ONLY orchestrates (SRP). Validation -> OrderValidator,
//      mapping -> OrderMapper. Every collaborator is an INTERFACE (DIP), so the whole
//      class is unit-testable with mocks. The "find or 404" rule lives once (DRY).
package com.dizon.app.service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;   // ✅ DIP: abstraction
    private final OrderMapper orderMapper;          // ✅ DIP: abstraction

    public OrderService(OrderRepository orderRepository,
                        OrderValidator orderValidator,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    public OrderResponse createOrder(OrderRequest request) {
        orderValidator.validate(request);                       // ✅ SRP: delegated
        Order order = new Order(request.customerName());
        for (OrderItemRequest itemReq : request.items()) {
            order.addItem(new OrderItem(itemReq.productName(), itemReq.price(), itemReq.quantity()));
        }
        return orderMapper.toResponse(orderRepository.save(order));   // ✅ SRP: delegated
    }

    public OrderResponse getOrderById(Long id) {
        return orderMapper.toResponse(findOrderOrThrow(id));
    }

    public OrderResponse updateOrderStatus(Long id, String status) {
        Order order = findOrderOrThrow(id);
        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        return orderMapper.toResponse(orderRepository.save(order));
    }

    // ✅ DRY: single source of truth for "find by id or 404"
    private Order findOrderOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
