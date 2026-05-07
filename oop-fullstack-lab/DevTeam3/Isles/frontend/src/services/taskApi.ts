import type { Task, TaskPayload } from '../types';

const API_URL = 'http://localhost:8080/api/tasks';

async function request<T>(url: string, options?: RequestInit): Promise<T> {
  const response = await fetch(url, {
    headers: {
      'Content-Type': 'application/json',
      ...options?.headers,
    },
    ...options,
  });

  if (!response.ok) {
    const error = await response.json().catch(() => ({ message: 'Request failed' }));
    throw new Error(error.message ?? 'Request failed');
  }

  if (response.status === 204) {
    return undefined as T;
  }

  return response.json();
}

export function getTasks(): Promise<Task[]> {
  return request<Task[]>(API_URL);
}

export function createTask(task: TaskPayload): Promise<Task> {
  return request<Task>(API_URL, {
    method: 'POST',
    body: JSON.stringify(task),
  });
}

export function updateTask(id: number, task: TaskPayload): Promise<Task> {
  return request<Task>(`${API_URL}/${id}`, {
    method: 'PUT',
    body: JSON.stringify(task),
  });
}

export function deleteTask(id: number): Promise<void> {
  return request<void>(`${API_URL}/${id}`, {
    method: 'DELETE',
  });
}
