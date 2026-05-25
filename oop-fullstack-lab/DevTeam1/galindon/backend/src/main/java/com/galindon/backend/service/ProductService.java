package com.galindon.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.galindon.backend.entity.Product;
import com.galindon.backend.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product add(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product product = repository.findById(id).orElseThrow();

        product.setName(updated.getName());
        product.setPrice(updated.getPrice());

        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}