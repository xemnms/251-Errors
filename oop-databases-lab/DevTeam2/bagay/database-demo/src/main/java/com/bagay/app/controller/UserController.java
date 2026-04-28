package com.bagay.app.controller;

import com.bagay.app.entity.User;
import com.bagay.app.dto.UserDTO;
import jakarta.validation.Valid;
import com.bagay.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * GET /api/users - Get all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * GET /api/users/{id} - Get user by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * GET /api/users/email/{email} - Get user by email
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    /**
     * POST /api/users - Create a new user
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRegular(userDto.getRegular() != null ? userDto.getRegular() : false);
        user.setRole(userDto.getRole());

        User createdUser = userService.createUser(user);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("data", createdUser);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * PUT /api/users/{id} - Update user
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDto) {
        User userDetails = new User();
        userDetails.setName(userDto.getName());
        userDetails.setEmail(userDto.getEmail());
        userDetails.setPhoneNumber(userDto.getPhoneNumber());
        userDetails.setRegular(userDto.getRegular() != null ? userDto.getRegular() : false);
        userDetails.setRole(userDto.getRole());

        User updatedUser = userService.updateUser(id, userDetails);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User updated successfully");
        response.put("data", updatedUser);
        
        return ResponseEntity.ok(response);
    }

    /**
     * DELETE /api/users/{id} - Delete user
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        
        return ResponseEntity.ok(response);
    }
}
