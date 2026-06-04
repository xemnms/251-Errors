// ===== BEFORE (GRASP lab) — grasp-ut-lab/DevTeam1/dizon =====
// SMELL: OrderService has THREE responsibilities:
//   (1) business logic, (2) inline validation, (3) entity->DTO mapping (toResponse).
// This violates SRP and makes validation/mapping impossible to swap or mock (DIP).
package com.app.service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest request) {
        // ❌ SRP/DIP violation: validation logic hardcoded inside the service
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }

        Order order = new Order(request.getCustomerName());
        if (request.getItems() != null) {
            for (OrderItemRequest itemReq : request.getItems()) {
                order.addItem(new OrderItem(itemReq.getProductName(), itemReq.getPrice(), itemReq.getQuantity()));
            }
        }
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public OrderResponse getOrderById(Long id) {
        // ❌ DRY violation: this findById+orElseThrow block is repeated in update & delete too
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    public OrderResponse updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)              // ❌ duplicated again
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        return toResponse(orderRepository.save(order));
    }

    // ❌ SRP violation: mapping logic baked into the service as a private method
    private OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse(
                order.getId(), order.getCustomerName(), order.getStatus(),
                order.calculateTotal(), order.getCreatedAt());
        // ❌ Immutability violation: items set AFTER construction via a setter
        if (order.getItems() != null) {
            response.setItems(order.getItems().stream()
                    .map(item -> new OrderItemRequest(item.getProductName(), item.getPrice(), item.getQuantity()))
                    .collect(Collectors.toList()));
        }
        return response;
    }
}
