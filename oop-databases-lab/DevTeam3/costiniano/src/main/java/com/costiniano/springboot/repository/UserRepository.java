package com.costiniano.springboot.repository;

import com.costiniano.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // That's it! This interface now has save(), findAll(), delete(), etc.
}