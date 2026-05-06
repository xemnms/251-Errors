package com.nepomuceno.app.repository;

import com.nepomuceno.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}