package com.dizon.springboot.repository;

import com.dizon.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by category
    List<Product> findByCategory(String category);

    // Check if product name exists
    boolean existsByName(String name);
}