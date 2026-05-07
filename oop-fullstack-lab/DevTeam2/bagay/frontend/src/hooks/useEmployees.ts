import { useCallback, useEffect, useState } from 'react';
import { employeeService } from '../services/employeeService';
import type { Employee, EmployeePayload } from '../types/Employee';

export function useEmployees() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [saving, setSaving] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const loadEmployees = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await employeeService.getAll();
      setEmployees(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to fetch employees');
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    void loadEmployees();
  }, [loadEmployees]);

  const createEmployee = useCallback(async (payload: EmployeePayload) => {
    setSaving(true);
    setError(null);
    try {
      const created = await employeeService.create(payload);
      setEmployees((current) => [created, ...current]);
      return created;
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to create employee');
      throw err;
    } finally {
      setSaving(false);
    }
  }, []);

  const updateEmployee = useCallback(async (id: number, payload: EmployeePayload) => {
    setSaving(true);
    setError(null);
    try {
      const updated = await employeeService.update(id, payload);
      setEmployees((current) =>
        current.map((employee) => (employee.id === id ? updated : employee)),
      );
      return updated;
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to update employee');
      throw err;
    } finally {
      setSaving(false);
    }
  }, []);

  const deleteEmployee = useCallback(async (id: number) => {
    setSaving(true);
    setError(null);
    try {
      await employeeService.delete(id);
      setEmployees((current) => current.filter((employee) => employee.id !== id));
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to delete employee');
      throw err;
    } finally {
      setSaving(false);
    }
  }, []);

  return {
    employees,
    loading,
    saving,
    error,
    loadEmployees,
    createEmployee,
    updateEmployee,
    deleteEmployee,
  };
}
