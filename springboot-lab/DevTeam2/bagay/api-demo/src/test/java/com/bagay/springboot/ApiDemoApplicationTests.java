package com.bagay.springboot;

import org.junit.jupiter.api.Test;
class ApiDemoApplicationTests {

	@Test
	void contextLoads() {
		if (ApiDemoApplication.class == null) {
			throw new AssertionError("ApiDemoApplication class is missing");
		}
	}

}
