package com.nepomuceno.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);


	}

}
/*
 * What changed from previous lab?
 * In the previous lab, data was hardcoded or stored in-memory, meaning all data
 * was lost every time the application restarted. In this lab, we replaced that
 * with real database persistence using Spring Data JPA, so data is now saved
 * permanently and survives restarts.
 *
 * Why database is better?
 * A database is better because it stores data permanently, supports multiple users
 * at the same time, allows complex queries, and keeps data organized and consistent.
 * Hardcoded data cannot grow, cannot be updated at runtime, and is not suitable
 * for real-world applications.
 *
 * How JPA helped?
 * JPA (Java Persistence API) helped by eliminating the need to write raw SQL queries.
 * Instead of manually handling database connections and statements, we simply used
 * annotations like @Entity, @Id, and @GeneratedValue, and extended JpaRepository
 * to get full CRUD operations automatically with minimal code.
 *
 * What changed when switching DB?
 * Only the application.properties file needed to be updated — the database URL,
 * driver, username, and password were changed from H2 to PostgreSQL. The Java code
 * (entities, repositories, services, controllers) required zero changes, which
 * demonstrates how JPA abstracts away the underlying database.
 */