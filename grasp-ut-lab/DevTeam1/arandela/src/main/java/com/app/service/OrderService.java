package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import java.util.List;

// GRASP: Indirection + Protected Variations - controller depends on this interface, not the impl
public interface OrderService {
    Order createOrder(OrderDTO dto);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order updateStatus(Long id, String status);
    void deleteOrder(Long id);
}
