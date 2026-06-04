package com.nepomuceno.app.repository;

import com.nepomuceno.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// GRASP: Indirection — acts as a layer between the service and the database
// The service never touches the DB directly; it always goes through this interface
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // GRASP: Indirection — Spring Data JPA generates the SQL; service stays clean
    List<Order> findByStatus(String status);
}
