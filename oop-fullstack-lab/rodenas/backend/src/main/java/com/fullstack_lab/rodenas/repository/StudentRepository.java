package com.fullstacklab.rodenas.repository;

import com.fullstacklab.rodenas.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}