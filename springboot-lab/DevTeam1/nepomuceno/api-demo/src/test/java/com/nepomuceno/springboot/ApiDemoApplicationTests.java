package com.nepomuceno.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiDemoApplicationTests {

	@Test
	void contextLoads() {
		if (ApiDemoApplication.class == null) {
			throw new AssertionError("ApiDemoApplication class is missing");
		}
	}

}
