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

	/*
	 * Step 10: Reflection
	 *
	 * What changed from previous lab?
	 * In this lab we moved from plain Java objects and in-memory collections (or manually managed
	 * persistence) to a structured persistence layer using Spring Data JPA and a database-backed
	 * repository. Previously the code likely stored and manipulated objects directly in memory or
	 * used simplistic file-based approaches; now entities are annotated with JPA mappings, we use
	 * Spring repositories for CRUD operations and the application lifecycle integrates with a
	 * relational database (H2 in-memory for development and tests, with optional PostgreSQL for
	 * production-like usage). Controllers and services were adapted to operate on domain entities
	 * and DTOs, and we introduced validation and a global exception handler to provide consistent
	 * API behavior.
	 *
	 * Why database is better?
	 * Databases provide durable, consistent, and concurrent storage for application data. They
	 * support transactions, indexing, querying, and concurrency control which are difficult to
	 * implement correctly and efficiently with ad-hoc file or memory approaches. A database also
	 * enables multiple application instances to share the same state, allows recovery after
	 * crashes, and provides mechanisms (backups, access control, auditing) that are essential for
	 * production systems. Using a relational database additionally enforces schema and data types
	 * which help maintain data integrity.
	 *
	 * How JPA helped?
	 * JPA (with Spring Data JPA) acted as a thin, declarative mapping layer between Java objects
	 * and relational tables. It reduced boilerplate by generating CRUD operations through
	 * repositories and allowed developers to focus on domain logic rather than SQL. JPA annotations
	 * describe relationships and persistence rules directly on entity classes, enabling the
	 * framework to manage object identity, lazy-loading, and cascades. With Spring Data we also
	 * gained easy query derivation and pagination utilities, simplifying data access patterns.
	 *
	 * What changed when switching DB?
	 * Switching from an embedded H2 database to PostgreSQL (or another RDBMS) mostly requires
	 * configuration changes (JDBC URL, driver, credentials, and dialect). However, practical
	 * differences can appear: SQL dialect differences may affect custom queries, data type
	 * mappings (e.g., boolean/timestamp/uuid handling) and certain functions or features. In
	 * production, external DBs bring persistence across restarts and better scaling/concurrency,
	 * but also require connection management, proper migrations (Flyway/Liquibase), and
	 * operational considerations like backups and monitoring. Using JPA minimizes code changes when
	 * switching databases because most mappings and repository code stay the same; only configuration
	 * and possibly small SQL-specific adjustments are necessary.
	 *
	 * Summary:
	 * By introducing JPA, DTOs, validation, exception handling, and explicit relationships we made
	 * the application more robust, maintainable, and ready for real-world usage: structured
	 * persistence, clearer API contracts, and consistent error handling all contribute to a higher
	 * quality codebase that is easier to evolve and deploy.
	 */