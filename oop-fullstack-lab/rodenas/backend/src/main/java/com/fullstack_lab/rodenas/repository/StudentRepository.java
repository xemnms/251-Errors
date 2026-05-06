package com.fullstack_lab.rodenas.repository;

import com.fullstack_lab.rodenas.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}