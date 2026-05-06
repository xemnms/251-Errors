package com.alvarez.demo.fullstack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository gives us save(), findAll(), deleteById(), etc. for free!
}