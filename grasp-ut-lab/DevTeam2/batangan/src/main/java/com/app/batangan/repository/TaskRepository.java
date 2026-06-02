package com.app.batangan.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.batangan.entity.Task;

// GRASP: Indirection - sits between Service and database
// GRASP: Protected Variations - if DB changes, only this layer changes
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Spring Data JPA auto-generates these SQL queries from method names!
    List<Task> findByStatus(String status);
    List<Task> findByPriority(String priority);
    List<Task> findByAssignedTo(String assignedTo);
    List<Task> findByStatusAndPriority(String status, String priority);
}