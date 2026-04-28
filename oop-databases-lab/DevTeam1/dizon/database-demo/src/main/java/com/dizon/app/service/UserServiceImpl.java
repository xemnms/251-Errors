package com.dizon.springboot.service;

import com.dizon.springboot.dto.UserDTO;
import com.dizon.springboot.entity.User;
import com.dizon.springboot.exception.DuplicateResourceException;
import com.dizon.springboot.exception.ResourceNotFoundException;
import com.dizon.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection (best practice over @Autowired on field)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ─── GET ALL ─────────────────────────────────────────────────────────────

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ─── GET BY ID ───────────────────────────────────────────────────────────

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
        return toDTO(user);
    }

    // ─── CREATE ──────────────────────────────────────────────────────────────

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateResourceException("A user with email '" + userDTO.getEmail() + "' already exists.");
        }
        User user = toEntity(userDTO);
        User saved = userRepository.save(user);
        return toDTO(saved);
    }

    // ─── UPDATE ──────────────────────────────────────────────────────────────

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));

        // Check email conflict only if the email is being changed
        if (!existing.getEmail().equals(userDTO.getEmail())
                && userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateResourceException("A user with email '" + userDTO.getEmail() + "' already exists.");
        }

        // Update any or all fields
        if (userDTO.getName() != null)        existing.setName(userDTO.getName());
        if (userDTO.getPhoneNumber() != null) existing.setPhoneNumber(userDTO.getPhoneNumber());
        if (userDTO.getEmail() != null)       existing.setEmail(userDTO.getEmail());
        if (userDTO.getRole() != null)        existing.setRole(userDTO.getRole());
        existing.setRegular(userDTO.isRegular());

        return toDTO(userRepository.save(existing));
    }

    // ─── DELETE ──────────────────────────────────────────────────────────────

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", id);
        }
        userRepository.deleteById(id);
    }

    // ─── Mapping Helpers ─────────────────────────────────────────────────────

    private UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.isRegular(),
                user.getRole()
        );
    }

    private User toEntity(UserDTO dto) {
        return new User(
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.isRegular(),
                dto.getRole()
        );
    }
}