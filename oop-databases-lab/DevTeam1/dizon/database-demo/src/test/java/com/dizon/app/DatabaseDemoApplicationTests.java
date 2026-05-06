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

@SpringBootTest(classes = ApiDemoApplication.class)
class DatabaseDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("Context Load Test")
    void contextLoads() {
        // This checks if the Spring context starts correctly
    }

    @Test
    @DisplayName("Test Persistence and Service Layers")
    void testDatabaseOperations() {
        // Test User creation
        UserDTO newUser = new UserDTO(null, "Andrew Dizon", "0917-111-2222", "dizon.andrew@nu.edu.ph", true, "Student");
        UserDTO savedUser = userService.createUser(newUser);
        
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("Andrew Dizon");

        // Test Product creation
        ProductDTO newProduct = new ProductDTO(null, "Java Textbook", "Advanced Spring Boot Guide", 1200.0, 50, "Education");
        ProductDTO savedProduct = productService.createProduct(newProduct);
        
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getCategory()).isEqualTo("Education");

        // Test Retrieval
        List<UserDTO> users = userService.getAllUsers();
        assertThat(users).isNotEmpty();
    }
}