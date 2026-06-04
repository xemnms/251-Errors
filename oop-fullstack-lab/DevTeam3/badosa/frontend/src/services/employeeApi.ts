import type { Employee, EmployeePayload } from '../types';

const API_BASE_URL = 'http://localhost:8080/api/employees';

async function handleResponse<T>(response: Response): Promise<T> {
  if (!response.ok) {
    let errorMessage = 'An error occurred';
    try {
      const errorData = await response.json() as Record<string, string>;
      if (errorData.error) {
        errorMessage = errorData.error;
      } else {
        // Validation errors key-value pairs
        errorMessage = Object.entries(errorData)
          .map(([field, msg]) => `${field.toUpperCase()}: ${msg}`)
          .join(', ');
      }
    } catch {
      errorMessage = response.statusText || `Request failed with status ${response.status}`;
    }
    throw new Error(errorMessage);
  }
  
  if (response.status === 204) {
    return {} as T;
  }
  return response.json() as Promise<T>;
}

export async function getEmployees(): Promise<Employee[]> {
  const response = await fetch(API_BASE_URL);
  return handleResponse<Employee[]>(response);
}

export async function createEmployee(payload: EmployeePayload): Promise<Employee> {
  const response = await fetch(API_BASE_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(payload),
  });
  return handleResponse<Employee>(response);
}

export async function updateEmployee(id: number, payload: EmployeePayload): Promise<Employee> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(payload),
  });
  return handleResponse<Employee>(response);
}

export async function deleteEmployee(id: number): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: 'DELETE',
  });
  await handleResponse<void>(response);
}
