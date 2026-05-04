package com.fullstack_lab.capunpon.repository;

import com.fullstack_lab.capunpon.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}