package com.dizon.springboot;

import com.dizon.springboot.dto.UserDTO;
import com.dizon.springboot.dto.ProductDTO;
import com.dizon.springboot.service.UserService;
import com.dizon.springboot.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DatabaseDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("Context Load Test")
    void contextLoads() {
        // This confirms the Spring Boot environment and H2 DB start successfully
    }

    @Test
    @DisplayName("Test Persistence and Service Layers")
    void testDatabaseOperations() {
        // 1. Create a Test User via DTO
        UserDTO newUser = new UserDTO(null, "Andrew Dizon", "0917-111-2222", "dizon.andrew@nu.edu.ph", true, "Student");
        UserDTO savedUser = userService.createUser(newUser);
        
        // Assertions: Ensure the DB generated an ID and saved the name
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("Andrew Dizon");

        // 2. Create a Test Product via DTO
        ProductDTO newProduct = new ProductDTO(null, "Java Textbook", "Advanced Spring Boot Guide", 1200.0, 50, "Education");
        ProductDTO savedProduct = productService.createProduct(newProduct);
        
        // Assertions: Ensure product data was persisted
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getCategory()).isEqualTo("Education");

        // 3. Verify the List logic
        List<UserDTO> users = userService.getAllUsers();
        assertThat(users).isNotEmpty();
    }
}