package com.flowstate.repository;

import com.flowstate.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository
    extends JpaRepository<Task, Long> {
}