package com.isles.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.isles.springboot.dto.CreateUserRequest;
import com.isles.springboot.dto.UpdateUserRequest;
import com.isles.springboot.entity.User;
import com.isles.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldCreateAndUpdateUser() {
        CreateUserRequest createRequest = new CreateUserRequest();
        createRequest.setName("Dan Marvin M. Isles");
        createRequest.setPhoneNumber("09171234567");
        createRequest.setEmail("dan@example.com");
        createRequest.setRegular(true);
        createRequest.setRole("Student");

        User createdUser = userService.createUser(createRequest);
        assertNotNull(createdUser.getId());
        assertEquals("Dan Marvin M. Isles", createdUser.getName());

        UpdateUserRequest updateRequest = new UpdateUserRequest();
        updateRequest.setRole("Regular Student");

        User updatedUser = userService.updateUser(createdUser.getId(), updateRequest);
        assertEquals("Regular Student", updatedUser.getRole());
    }
}
