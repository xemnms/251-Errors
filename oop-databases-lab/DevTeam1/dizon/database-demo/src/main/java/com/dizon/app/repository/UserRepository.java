package com.dizon.springboot.repository;

import com.dizon.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if an email already exists (used for duplicate validation)
    boolean existsByEmail(String email);

    // Find by email for business logic
    Optional<User> findByEmail(String email);
}