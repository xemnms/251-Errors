package com.batangan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.batangan.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}