package com.arandela.database_demo.service;

import com.arandela.database_demo.entity.Product;
import com.arandela.database_demo.exception.ResourceNotFoundException;
import com.arandela.database_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        if (updatedProduct.getName() != null) existing.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null) existing.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getPrice() != null) existing.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getCategory() != null) existing.setCategory(updatedProduct.getCategory());
        if (updatedProduct.getStock() != null) existing.setStock(updatedProduct.getStock());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
    }
}
