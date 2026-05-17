package com.app.costiniano.controller;

import com.app.costiniano.dto.OrderRequestDto;
import com.app.costiniano.dto.OrderResponseDto;
import com.app.costiniano.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrderResponseDto> checkout(@RequestBody OrderRequestDto request) {
        OrderResponseDto response = orderService.checkout(request);
        return ResponseEntity.ok(response);
    }
}