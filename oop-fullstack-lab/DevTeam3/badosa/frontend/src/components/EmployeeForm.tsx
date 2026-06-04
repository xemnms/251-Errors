import React, { useEffect, useState } from 'react';
import type { Employee, EmployeePayload } from '../types';

interface EmployeeFormProps {
  editingEmployee: Employee | null;
  onSubmit: (payload: EmployeePayload) => Promise<void>;
  onCancelEdit: () => void;
}

const initialPayload: EmployeePayload = {
  name: '',
  email: '',
  department: '',
  jobTitle: '',
  salary: 0,
};

export function EmployeeForm({ editingEmployee, onSubmit, onCancelEdit }: EmployeeFormProps) {
  const [payload, setPayload] = useState<EmployeePayload>(initialPayload);
  const [submitting, setSubmitting] = useState(false);
  const [localError, setLocalError] = useState('');

  useEffect(() => {
    if (editingEmployee) {
      setPayload({
        name: editingEmployee.name,
        email: editingEmployee.email,
        department: editingEmployee.department,
        jobTitle: editingEmployee.jobTitle,
        salary: editingEmployee.salary,
      });
    } else {
      setPayload(initialPayload);
    }
    setLocalError('');
  }, [editingEmployee]);

  function handleChange(e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) {
    const { name, value } = e.target;
    setPayload((prev) => ({
      ...prev,
      [name]: name === 'salary' ? parseFloat(value) || 0 : value,
    }));
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setLocalError('');

    // Frontend validations
    if (!payload.name.trim()) return setLocalError('Name is required');
    if (!payload.email.trim()) return setLocalError('Email is required');
    if (!payload.department.trim()) return setLocalError('Department is required');
    if (!payload.jobTitle.trim()) return setLocalError('Job title is required');
    if (payload.salary <= 0) return setLocalError('Salary must be greater than zero');

    setSubmitting(true);
    try {
      await onSubmit(payload);
      if (!editingEmployee) {
        setPayload(initialPayload);
      }
    } catch (err) {
      setLocalError(err instanceof Error ? err.message : 'Error submitting form');
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <section className="form-card card-panel">
      <h2>{editingEmployee ? 'Edit Employee Details' : 'Register New Employee'}</h2>
      <p className="subtitle">Please provide accurate organizational details</p>

      {localError && <div className="form-error-banner">{localError}</div>}

      <form onSubmit={handleSubmit} className="portal-form">
        <div className="form-group">
          <label htmlFor="name-input">Full Name</label>
          <input
            id="name-input"
            type="text"
            name="name"
            placeholder="e.g. Bien Manuel Badosa"
            value={payload.name}
            onChange={handleChange}
            required
            disabled={submitting}
          />
        </div>

        <div className="form-group">
          <label htmlFor="email-input">Work Email</label>
          <input
            id="email-input"
            type="email"
            name="email"
            placeholder="e.g. badosa@company.com"
            value={payload.email}
            onChange={handleChange}
            required
            disabled={submitting}
          />
        </div>

        <div className="form-row">
          <div className="form-group">
            <label htmlFor="dept-input">Department</label>
            <select
              id="dept-input"
              name="department"
              value={payload.department}
              onChange={handleChange}
              required
              disabled={submitting}
            >
              <option value="">Select Department</option>
              <option value="Engineering">Engineering</option>
              <option value="Product">Product</option>
              <option value="Marketing">Marketing</option>
              <option value="Human Resources">Human Resources</option>
              <option value="Finance">Finance</option>
            </select>
          </div>

          <div className="form-group">
            <label htmlFor="job-input">Job Title</label>
            <input
              id="job-input"
              type="text"
              name="jobTitle"
              placeholder="e.g. Software Engineer"
              value={payload.jobTitle}
              onChange={handleChange}
              required
              disabled={submitting}
            />
          </div>
        </div>

        <div className="form-group">
          <label htmlFor="salary-input">Monthly Salary ($)</label>
          <input
            id="salary-input"
            type="number"
            name="salary"
            placeholder="e.g. 8500"
            min="1"
            step="any"
            value={payload.salary === 0 ? '' : payload.salary}
            onChange={handleChange}
            required
            disabled={submitting}
          />
        </div>

        <div className="form-actions">
          {editingEmployee && (
            <button
              type="button"
              className="btn btn-secondary"
              onClick={onCancelEdit}
              disabled={submitting}
            >
              Cancel Edit
            </button>
          )}
          <button type="submit" className="btn btn-primary" disabled={submitting}>
            {submitting ? 'Processing...' : editingEmployee ? 'Update Profile' : 'Add Employee'}
          </button>
        </div>
      </form>
    </section>
  );
}
