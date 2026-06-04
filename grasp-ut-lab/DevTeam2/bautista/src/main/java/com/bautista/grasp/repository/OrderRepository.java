package com.bautista.grasp.repository;

import com.bautista.grasp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * GRASP: Indirection
 * This interface decouples the service layer from database implementation.
 * The service depends on abstraction, not concrete persistence logic.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}