import React, { useState } from 'react';
import type { Employee } from '../types';

interface EmployeeListProps {
  employees: Employee[];
  loading: boolean;
  onEdit: (employee: Employee) => void;
  onDelete: (id: number) => Promise<void>;
}

export function EmployeeList({ employees, loading, onEdit, onDelete }: EmployeeListProps) {
  const [pendingDeleteId, setPendingDeleteId] = useState<number | null>(null);
  const [deleting, setDeleting] = useState(false);

  async function confirmDelete(id: number) {
    setDeleting(true);
    try {
      await onDelete(id);
    } finally {
      setPendingDeleteId(null);
      setDeleting(false);
    }
  }

  if (loading) {
    return (
      <div className="list-status">
        <div className="spinner"></div>
        <p>Retrieving employee directory...</p>
      </div>
    );
  }

  if (employees.length === 0) {
    return (
      <div className="list-status empty-state">
        <span className="icon">👥</span>
        <h3>Directory is Empty</h3>
        <p>No employee profiles registered yet. Use the form to register one.</p>
      </div>
    );
  }

  return (
    <div className="table-responsive">
      {/* Inline Delete Confirmation Overlay */}
      {pendingDeleteId !== null && (
        <div className="delete-confirm-overlay">
          <div className="delete-confirm-dialog">
            <p>
              Are you sure you want to remove{' '}
              <strong>{employees.find((e) => e.id === pendingDeleteId)?.name}</strong> from the directory?
            </p>
            <div className="confirm-actions">
              <button
                id="confirm-delete-btn"
                type="button"
                className="btn btn-danger"
                onClick={() => void confirmDelete(pendingDeleteId)}
                disabled={deleting}
              >
                {deleting ? 'Deleting...' : 'Yes, Delete'}
              </button>
              <button
                id="cancel-delete-btn"
                type="button"
                className="btn btn-secondary"
                onClick={() => setPendingDeleteId(null)}
                disabled={deleting}
              >
                Cancel
              </button>
            </div>
          </div>
        </div>
      )}

      <table className="employee-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Department</th>
            <th>Job Title</th>
            <th>Salary</th>
            <th className="actions-header">Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id} className="employee-row">
              <td>
                <div className="employee-info">
                  <span className="avatar">{emp.name.charAt(0).toUpperCase()}</span>
                  <div>
                    <span className="emp-name">{emp.name}</span>
                    <span className="emp-email">{emp.email}</span>
                  </div>
                </div>
              </td>
              <td>
                <span className={`badge badge-${emp.department.toLowerCase().replace(/\s+/g, '-')}`}>
                  {emp.department}
                </span>
              </td>
              <td className="emp-title">{emp.jobTitle}</td>
              <td className="emp-salary">
                ${emp.salary.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 })}
              </td>
              <td>
                <div className="actions-cell">
                  <button
                    type="button"
                    id={`edit-btn-${emp.id}`}
                    className="action-btn edit-btn"
                    onClick={() => onEdit(emp)}
                    title="Edit profile"
                  >
                    ✏️ Edit
                  </button>
                  <button
                    type="button"
                    id={`delete-btn-${emp.id}`}
                    className="action-btn delete-btn"
                    onClick={() => setPendingDeleteId(emp.id)}
                    title="Delete profile"
                  >
                    🗑️ Delete
                  </button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
