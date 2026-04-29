package com.alvarez.app.springboot.repository;

import com.alvarez.app.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}