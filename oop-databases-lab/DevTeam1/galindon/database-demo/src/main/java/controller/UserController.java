package com.galindon.app.controller;

import com.galindon.app.entity.User;
import com.galindon.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users — get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /api/users/{id} — get one user
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/users — create a user
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT /api/users/{id} — update a user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE /api/users/{id} — delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}