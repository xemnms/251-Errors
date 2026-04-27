package com.rodenas.springboot.service;

import com.rodenas.springboot.dto.UserDTO;
import com.rodenas.springboot.entity.User;
import com.rodenas.springboot.exception.ResourceNotFoundException;
import com.rodenas.springboot.repository.UserRepository;
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
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRegular(dto.isRegular());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDTO dto) {
        User user = getUserById(id);
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRegular(dto.isRegular());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }
}