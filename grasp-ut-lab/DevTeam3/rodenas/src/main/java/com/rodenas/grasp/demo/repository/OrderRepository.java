package com.rodenas.grasp.demo.repository;

import com.rodenas.grasp.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// GRASP: Indirection - acts as layer between DB and Service
// GRASP: Low Coupling - Service depends on this interface, not DB directly
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
    List<Order> findByCustomerName(String customerName);
}