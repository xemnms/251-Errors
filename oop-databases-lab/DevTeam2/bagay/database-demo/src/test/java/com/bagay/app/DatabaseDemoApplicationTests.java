package com.bagay.app;

import com.bagay.app.entity.Product;
import com.bagay.app.entity.User;
import com.bagay.app.repository.ProductRepository;
import com.bagay.app.repository.UserRepository;
import com.bagay.app.service.ProductService;
import com.bagay.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
		assertNotNull(userRepository);
		assertNotNull(productRepository);
		assertNotNull(userService);
		assertNotNull(productService);
	}

	@Test
	void testUserCreateAndRetrieve() {
		// Create a user
		User user = new User();
		user.setName("Test User");
		user.setEmail("test@example.com");
		user.setPhoneNumber("555-0000");
		user.setRegular(true);
		user.setRole("CUSTOMER");

		User savedUser = userRepository.save(user);
		assertNotNull(savedUser.getId());

		// Retrieve the user
		User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);
		assertNotNull(retrievedUser);
		assertEquals("Test User", retrievedUser.getName());
		assertEquals("test@example.com", retrievedUser.getEmail());
	}

	@Test
	void testProductCreateAndRetrieve() {
		// Create a product
		Product product = new Product();
		product.setName("Test Product");
		product.setDescription("A test product");
		product.setPrice(99.99);
		product.setQuantity(10);
		product.setCategory("Electronics");

		Product savedProduct = productRepository.save(product);
		assertNotNull(savedProduct.getId());

		// Retrieve the product
		Product retrievedProduct = productRepository.findById(savedProduct.getId()).orElse(null);
		assertNotNull(retrievedProduct);
		assertEquals("Test Product", retrievedProduct.getName());
		assertEquals(99.99, retrievedProduct.getPrice());
	}

	@Test
	void testUserUpdate() {
		// Create and save a user
		User user = new User();
		user.setName("Original Name");
		user.setEmail("update@example.com");
		user.setPhoneNumber("555-1111");
		user.setRegular(false);
		user.setRole("USER");

		User savedUser = userRepository.save(user);

		// Update the user
		savedUser.setName("Updated Name");
		savedUser.setRole("ADMIN");
		userRepository.save(savedUser);

		// Verify update
		User updatedUser = userRepository.findById(savedUser.getId()).orElse(null);
		assertNotNull(updatedUser);
		assertEquals("Updated Name", updatedUser.getName());
		assertEquals("ADMIN", updatedUser.getRole());
	}

	@Test
	void testProductDelete() {
		// Create and save a product
		Product product = new Product();
		product.setName("Delete Test");
		product.setPrice(50.00);
		product.setQuantity(5);
		product.setCategory("Test");

		Product savedProduct = productRepository.save(product);
		Long productId = savedProduct.getId();

		// Delete the product
		productRepository.deleteById(productId);

		// Verify deletion
		assertFalse(productRepository.existsById(productId));
	}

}
