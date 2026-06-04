package com.nepomuceno.app.controller;

import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// GRASP: Controller — handles all incoming HTTP requests for orders; delegates to service
// GRASP: High Cohesion — only HTTP concerns here; zero business or persistence logic
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // GRASP: Low Coupling — depends on OrderService, not on repository or entity directly
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<OrderResponse> processPayment(
            @PathVariable Long id,
            @RequestParam String type) {
        return ResponseEntity.ok(orderService.processPayment(id, type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
