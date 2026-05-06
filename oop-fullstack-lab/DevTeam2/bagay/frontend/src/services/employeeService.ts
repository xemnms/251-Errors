import type { Employee, EmployeePayload } from '../types/Employee';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL?.trim() ?? '';
const EMPLOYEE_ENDPOINT = API_BASE_URL
  ? `${API_BASE_URL}/api/employees`
  : '/api/employees';

async function request<T>(url: string, options?: RequestInit): Promise<T> {
  const response = await fetch(url, {
    headers: {
      'Content-Type': 'application/json',
      ...(options?.headers ?? {}),
    },
    ...options,
  });

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(errorText || `Request failed with status ${response.status}`);
  }

  if (response.status === 204) {
    return undefined as T;
  }

  return (await response.json()) as T;
}

export const employeeService = {
  getAll: () => request<Employee[]>(EMPLOYEE_ENDPOINT),
  getById: (id: number) => request<Employee>(`${EMPLOYEE_ENDPOINT}/${id}`),
  create: (payload: EmployeePayload) =>
    request<Employee>(EMPLOYEE_ENDPOINT, {
      method: 'POST',
      body: JSON.stringify(payload),
    }),
  update: (id: number, payload: EmployeePayload) =>
    request<Employee>(`${EMPLOYEE_ENDPOINT}/${id}`, {
      method: 'PUT',
      body: JSON.stringify(payload),
    }),
  delete: (id: number) =>
    request<void>(`${EMPLOYEE_ENDPOINT}/${id}`, {
      method: 'DELETE',
    }),
};
