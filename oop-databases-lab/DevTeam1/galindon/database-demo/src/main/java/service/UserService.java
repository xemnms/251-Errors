package com.galindon.app.service;

import com.galindon.app.entity.User;
import com.galindon.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}