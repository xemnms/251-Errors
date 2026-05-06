package com.alvarez.app.springboot.repository;

import com.alvarez.app.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}