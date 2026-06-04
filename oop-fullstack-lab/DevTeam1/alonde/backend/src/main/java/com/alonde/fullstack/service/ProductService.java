package com.alonde.fullstack.service;

import com.alonde.fullstack.dto.ProductDTO;
import com.alonde.fullstack.model.Product;
import com.alonde.fullstack.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repo.findById(id);
    }

    public Product createProduct(ProductDTO dto) {
        Product p = new Product(dto.getName(), dto.getDescription(),
                dto.getPrice());
        return repo.save(p);
    }

    public Optional<Product> updateProduct(Long id, ProductDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setPrice(dto.getPrice());
            return repo.save(existing);
        });
    }

    public boolean deleteProduct(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}