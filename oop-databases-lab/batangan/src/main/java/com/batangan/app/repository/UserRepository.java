package com.batangan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.batangan.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}