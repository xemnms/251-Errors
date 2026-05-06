package com.bagay.app.controller;

import com.bagay.app.entity.Product;
import com.bagay.app.entity.User;
import com.bagay.app.dto.ProductDTO;
import com.bagay.app.repository.UserRepository;
import jakarta.validation.Valid;
import com.bagay.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    /**
     * GET /api/products - Get all products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/{id} - Get product by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * GET /api/products/category/{category} - Get products by category
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/search - Search products by name
     */
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name) {
        List<Product> products = productService.searchProducts(name);
        return ResponseEntity.ok(products);
    }

    /**
     * POST /api/products - Create a new product
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(productDto.getCategory());

        if (productDto.getOwnerId() != null) {
            User owner = userRepository.findById(productDto.getOwnerId()).orElse(null);
            product.setOwner(owner);
        }

        Product createdProduct = productService.createProduct(product);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product created successfully");
        response.put("data", createdProduct);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * PUT /api/products/{id} - Update product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDto) {
        Product productDetails = new Product();
        productDetails.setName(productDto.getName());
        productDetails.setDescription(productDto.getDescription());
        productDetails.setPrice(productDto.getPrice());
        productDetails.setQuantity(productDto.getQuantity());
        productDetails.setCategory(productDto.getCategory());

        if (productDto.getOwnerId() != null) {
            User owner = userRepository.findById(productDto.getOwnerId()).orElse(null);
            productDetails.setOwner(owner);
        }

        Product updatedProduct = productService.updateProduct(id, productDetails);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product updated successfully");
        response.put("data", updatedProduct);
        
        return ResponseEntity.ok(response);
    }

    /**
     * DELETE /api/products/{id} - Delete product
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully");
        
        return ResponseEntity.ok(response);
    }
}
