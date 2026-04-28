package com.costiniano.springboot.controller;

import com.costiniano.springboot.entity.User;
import com.costiniano.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // READ All (GET /api/users)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ One (GET /api/users/{id})
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // CREATE (POST /api/users)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // UPDATE (PUT /api/users/{id})
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setRegular(userDetails.isRegular());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    // DELETE (DELETE /api/users/{id})
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted.";
    }
}