package com.nu.bscs.b.task;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(Long id) {
		super("Task with id " + id + " was not found");
	}
}
