package com.bagay.app.service;

import com.bagay.app.entity.Product;
import com.bagay.app.exception.InvalidInputException;
import com.bagay.app.exception.ResourceNotFoundException;
import com.bagay.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get product by ID
     */
    public Product getProductById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("Product ID must be positive");
        }
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    /**
     * Get products by category
     */
    public List<Product> getProductsByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new InvalidInputException("Category cannot be null or empty");
        }
        List<Product> products = productRepository.findByCategory(category);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found for category: " + category);
        }
        return products;
    }

    /**
     * Search products by name
     */
    public List<Product> searchProducts(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Search term cannot be null or empty");
        }
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found matching: " + name);
        }
        return products;
    }

    /**
     * Create a new product
     */
    public Product createProduct(Product product) {
        validateProductInput(product);
        return productRepository.save(product);
    }

    /**
     * Update product details
     */
    public Product updateProduct(Long id, Product productDetails) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("Product ID must be positive");
        }
        
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        if (productDetails.getName() != null && !productDetails.getName().isEmpty()) {
            existingProduct.setName(productDetails.getName());
        }
        if (productDetails.getDescription() != null && !productDetails.getDescription().isEmpty()) {
            existingProduct.setDescription(productDetails.getDescription());
        }
        if (productDetails.getPrice() != null && productDetails.getPrice() > 0) {
            existingProduct.setPrice(productDetails.getPrice());
        }
        if (productDetails.getQuantity() != null && productDetails.getQuantity() >= 0) {
            existingProduct.setQuantity(productDetails.getQuantity());
        }
        if (productDetails.getCategory() != null && !productDetails.getCategory().isEmpty()) {
            existingProduct.setCategory(productDetails.getCategory());
        }

        return productRepository.save(existingProduct);
    }

    /**
     * Delete product by ID
     */
    public void deleteProduct(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("Product ID must be positive");
        }
        
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }

    /**
     * Validate product input
     */
    private void validateProductInput(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new InvalidInputException("Product name cannot be null or empty");
        }
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new InvalidInputException("Price must be a positive number");
        }
        if (product.getQuantity() == null || product.getQuantity() < 0) {
            throw new InvalidInputException("Quantity cannot be negative");
        }
        if (product.getCategory() == null || product.getCategory().isEmpty()) {
            throw new InvalidInputException("Category cannot be null or empty");
        }
    }
}
