package com.alonde.app.service;

import com.alonde.app.entity.User;
import com.alonde.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setPhoneNumber(updatedUser.getPhoneNumber());
        existing.setRole(updatedUser.getRole());
        existing.setRegular(updatedUser.isRegular());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
