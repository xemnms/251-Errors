import React, { useEffect, useState } from 'react';
import { EmployeeForm } from './components/EmployeeForm';
import { EmployeeList } from './components/EmployeeList';
import {
  createEmployee,
  deleteEmployee,
  getEmployees,
  updateEmployee,
} from './services/employeeApi';
import type { Employee, EmployeePayload } from './types';

export default function App() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [editingEmployee, setEditingEmployee] = useState<Employee | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  async function loadEmployees() {
    setLoading(true);
    setError('');
    try {
      const data = await getEmployees();
      setEmployees(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to connect to employee API');
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    void loadEmployees();
  }, []);

  async function handleSubmit(payload: EmployeePayload) {
    setError('');
    if (editingEmployee) {
      const updated = await updateEmployee(editingEmployee.id, payload);
      setEmployees((current) =>
        current.map((emp) => (emp.id === updated.id ? updated : emp))
      );
      setEditingEmployee(null);
    } else {
      const created = await createEmployee(payload);
      setEmployees((current) => [...current, created]);
    }
  }

  async function handleDelete(id: number) {
    setError('');
    try {
      await deleteEmployee(id);
      setEmployees((current) => current.filter((emp) => emp.id !== id));
      if (editingEmployee?.id === id) {
        setEditingEmployee(null);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Deletion failed');
    }
  }

  return (
    <main className="app-shell">
      <section className="page-header" id="main-header">
        <div>
          <h1>Employee Registry Portal</h1>
          <p>Full-Stack CRUD Application &bull; Spring Boot, React, and PostgreSQL</p>
        </div>
        <button
          type="button"
          className="refresh-btn"
          onClick={() => void loadEmployees()}
          disabled={loading}
        >
          🔄 Reload Directory
        </button>
      </section>

      {error && (
        <div className="error-banner" role="alert" id="error-message">
          <strong>System Message:</strong> {error}
        </div>
      )}

      <section className="workspace">
        <EmployeeForm
          editingEmployee={editingEmployee}
          onCancelEdit={() => setEditingEmployee(null)}
          onSubmit={handleSubmit}
        />
        <section className="list-panel card-panel">
          <h2>Active Directory</h2>
          <EmployeeList
            employees={employees}
            loading={loading}
            onEdit={setEditingEmployee}
            onDelete={handleDelete}
          />
        </section>
      </section>
    </main>
  );
}
