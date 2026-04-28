package com.bautista.springboot.service;

import com.bautista.springboot.entity.Product;
import com.bautista.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // GET ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // CREATE
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // UPDATE
    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setStock(updatedProduct.getStock());

        return productRepository.save(product);
    }

    // DELETE
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}