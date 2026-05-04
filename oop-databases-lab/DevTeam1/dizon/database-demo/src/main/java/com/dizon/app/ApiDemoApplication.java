package com.dizon.springboot; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * # 📝 Step 10: Reflection - CRUD API with H2 -> PostgreSQL
 * * 1. What changed from previous lab?
 * The application transitioned from using hardcoded, volatile in-memory data
 * to using a persistent database managed by Spring Data JPA.
 * * 2. Why database is better?
 * Databases provide data persistence (data remains after restart), integrity, 
 * and scalability, which are essential for any real-world backend system.
 * * 3. How JPA helped?
 * JPA abstracted the complex SQL queries into simple Java interfaces, 
 * allowing for faster development and cleaner separation of concerns.
 * * 4. What changed when switching DB?
 * Only the configuration in application.properties changed. The Java code 
 * remained identical, demonstrating database independence.
 */
@SpringBootApplication
public class ApiDemoApplication { 

    public static void main(String[] args) {
        SpringApplication.run(ApiDemoApplication.class, args);
    }

}