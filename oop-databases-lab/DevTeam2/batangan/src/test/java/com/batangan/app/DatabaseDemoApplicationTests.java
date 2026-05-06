package com.batangan.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
/*
What changed from previous lab?
We changed from using hardcoded or in-memory data to storing data in a real database using JPA.

Why database is better?
Because data is saved permanently and doesn’t disappear when the app stops.

How JPA helped?
JPA made it easier to connect Java objects to the database without writing SQL manually.

What changed when switching DB?
We only changed the configuration from H2 to PostgreSQL, but the code stayed mostly the same.
*/
