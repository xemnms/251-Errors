package com.acosta.springboot.repository;

import com.acosta.springboot.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection - acts as a middleman between OrderService and the database
// GRASP: Protected Variations - hides database details behind a stable interface
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
