package com.nepomuceno.app.repository;

import com.nepomuceno.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}