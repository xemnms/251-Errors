package com.costiniano.springboot.entity;

import com.costiniano.springboot.entity.Product; 
import com.costiniano.springboot.repository.ProductRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product details) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(details.getName());
            product.setPrice(details.getPrice());
            product.setDescription(details.getDescription());
            product.setStock(details.getStock());
            product.setCategory(details.getCategory());
            return productRepository.save(product);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product deleted.";
    }
}