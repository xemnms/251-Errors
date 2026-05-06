package com.bagay.app.service;

import com.bagay.app.entity.User;
import com.bagay.app.exception.InvalidInputException;
import com.bagay.app.exception.ResourceNotFoundException;
import com.bagay.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Get all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get user by ID
     */
    public User getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("User ID must be positive");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    /**
     * Get user by email
     */
    public User getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidInputException("Email cannot be null or empty");
        }
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    /**
     * Create a new user
     */
    public User createUser(User user) {
        validateUserInput(user);
        
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new InvalidInputException("Email already exists: " + user.getEmail());
        }
        
        return userRepository.save(user);
    }

    /**
     * Update user details
     */
    public User updateUser(Long id, User userDetails) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("User ID must be positive");
        }
        
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        if (userDetails.getName() != null && !userDetails.getName().isEmpty()) {
            existingUser.setName(userDetails.getName());
        }
        if (userDetails.getEmail() != null && !userDetails.getEmail().isEmpty()) {
            // Check if new email is already taken by another user
            Optional<User> userWithEmail = userRepository.findByEmail(userDetails.getEmail());
            if (userWithEmail.isPresent() && !userWithEmail.get().getId().equals(id)) {
                throw new InvalidInputException("Email already exists: " + userDetails.getEmail());
            }
            existingUser.setEmail(userDetails.getEmail());
        }
        if (userDetails.getPhoneNumber() != null && !userDetails.getPhoneNumber().isEmpty()) {
            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        }
        if (userDetails.getRole() != null && !userDetails.getRole().isEmpty()) {
            existingUser.setRole(userDetails.getRole());
        }
        existingUser.setRegular(userDetails.isRegular());

        return userRepository.save(existingUser);
    }

    /**
     * Delete user by ID
     */
    public void deleteUser(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("User ID must be positive");
        }
        
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    /**
     * Validate user input
     */
    private void validateUserInput(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new InvalidInputException("Name cannot be null or empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidInputException("Email cannot be null or empty");
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new InvalidInputException("Phone number cannot be null or empty");
        }
        if (user.getRole() == null || user.getRole().isEmpty()) {
            throw new InvalidInputException("Role cannot be null or empty");
        }
    }
}
