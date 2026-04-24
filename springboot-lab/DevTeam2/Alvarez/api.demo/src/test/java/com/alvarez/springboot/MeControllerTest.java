package com.alvarez.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMe() throws Exception {
        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}

 /* ========= CODE-BASED ANALYSIS ========== 
 1. How did you create your Spring Boot project?
* I created it using Spring Initializr (start.spring.io),
* selecting Maven, Java 21, Spring Boot, and adding Spring Web dependency.
     
2. What is the purpose of @RestController annotation?
* @RestController tells Spring that this class handles HTTP requests
* and automatically returns data (not views like HTML pages).
* It is a combination of @Controller + @ResponseBody.

3. What does @GetMapping("/me") do?
* It maps HTTP GET requests sent to "/me"
* to this method, so when you visit /me in the browser,
* this method runs.

4. Why did you change from returning a String to a Map?
* A String only returns plain text.
* A Map allows structured key-value data,
* which is better for APIs because it becomes JSON automatically.

5. How does Spring Boot handle JSON responses automatically?
* Spring Boot uses Jackson library internally.
* When you return a Map or Object, it automatically converts it to JSON
* and sends it as the HTTP response.
*/
 