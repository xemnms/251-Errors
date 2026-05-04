import { useEmployeeForm } from '../../hooks/useEmployeeForm';
import type { Employee, EmployeePayload } from '../../types/Employee';

type EmployeeFormProps = {
  initialEmployee?: Employee | null;
  isSubmitting: boolean;
  onSubmit: (payload: EmployeePayload) => Promise<void>;
  onCancelEdit?: () => void;
};

export function EmployeeForm({
  initialEmployee,
  isSubmitting,
  onSubmit,
  onCancelEdit,
}: EmployeeFormProps) {
  const { formValues, updateField, reset } = useEmployeeForm(initialEmployee);

  const isEditing = Boolean(initialEmployee);

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    await onSubmit(formValues);
    if (!isEditing) {
      reset();
    }
  };

  return (
    <form className="employee-form" onSubmit={handleSubmit}>
      <h2>{isEditing ? 'Edit Employee' : 'Add Employee'}</h2>

      <label>
        First Name
        <input
          required
          value={formValues.firstName}
          onChange={(e) => updateField('firstName', e.target.value)}
        />
      </label>

      <label>
        Last Name
        <input
          required
          value={formValues.lastName}
          onChange={(e) => updateField('lastName', e.target.value)}
        />
      </label>

      <label>
        Email
        <input
          required
          type="email"
          value={formValues.email}
          onChange={(e) => updateField('email', e.target.value)}
        />
      </label>

      <label>
        Position
        <input
          value={formValues.position}
          onChange={(e) => updateField('position', e.target.value)}
        />
      </label>

      <label>
        Hire Date
        <input
          type="date"
          value={formValues.hireDate ?? ''}
          onChange={(e) => updateField('hireDate', e.target.value)}
        />
      </label>

      <label>
        Salary
        <input
          type="number"
          step="0.01"
          min="0"
          value={formValues.salary}
          onChange={(e) => updateField('salary', Number(e.target.value))}
        />
      </label>

      <label className="checkbox-label">
        <input
          type="checkbox"
          checked={formValues.active}
          onChange={(e) => updateField('active', e.target.checked)}
        />
        Active Employee
      </label>

      <div className="form-actions">
        <button type="submit" disabled={isSubmitting}>
          {isSubmitting ? 'Saving...' : isEditing ? 'Update' : 'Create'}
        </button>
        {isEditing && onCancelEdit ? (
          <button
            type="button"
            className="button-secondary"
            onClick={onCancelEdit}
            disabled={isSubmitting}
          >
            Cancel
          </button>
        ) : null}
      </div>
    </form>
  );
}
