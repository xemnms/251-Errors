package com.app.alvarez.repository;

import com.app.alvarez.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection - repository mediates between the service and persistence technology.
public interface OrderRepository extends JpaRepository<Order, Long> {
}