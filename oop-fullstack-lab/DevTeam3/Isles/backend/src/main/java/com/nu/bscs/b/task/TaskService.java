package com.nu.bscs.b.task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Long id, Task updatedTask) {
		Task existingTask = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));

		existingTask.setTitle(updatedTask.getTitle());
		existingTask.setDescription(updatedTask.getDescription());
		existingTask.setCompleted(updatedTask.isCompleted());

		return taskRepository.save(existingTask);
	}

	public void deleteTask(Long id) {
		if (!taskRepository.existsById(id)) {
			throw new TaskNotFoundException(id);
		}

		taskRepository.deleteById(id);
	}
}
