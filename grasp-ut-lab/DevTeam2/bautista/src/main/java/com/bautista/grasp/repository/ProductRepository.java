package com.bautista.grasp.repository;

import com.bautista.grasp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * GRASP: Indirection
 * Provides abstraction over product persistence operations.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}