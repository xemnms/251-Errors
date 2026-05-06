package com.acosta.springboot.controller;

import com.acosta.springboot.entity.Product;
import com.acosta.springboot.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET all
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // PUT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            return productRepository.save(product);
        }).orElse(null);
    }

    
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}