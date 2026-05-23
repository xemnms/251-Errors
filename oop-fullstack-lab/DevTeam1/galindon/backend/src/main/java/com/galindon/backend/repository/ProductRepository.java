package com.galindon.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galindon.backend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}