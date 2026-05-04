package com.nepomuceno.app.service;

import com.nepomuceno.app.dto.UserDTO;
import com.nepomuceno.app.entity.User;
import com.nepomuceno.app.exception.ResourceNotFoundException;
import com.nepomuceno.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User create(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setRegular(dto.isRegular());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public User update(Long id, UserDTO dto) {
        User user = getById(id);
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setRegular(dto.isRegular());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(getById(id));
    }
}