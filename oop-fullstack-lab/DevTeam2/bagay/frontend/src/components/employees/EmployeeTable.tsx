import type { Employee } from '../../types/Employee';

type EmployeeTableProps = {
  employees: Employee[];
  loading: boolean;
  busy: boolean;
  onEdit: (employee: Employee) => void;
  onDelete: (id: number) => Promise<void>;
};

export function EmployeeTable({
  employees,
  loading,
  busy,
  onEdit,
  onDelete,
}: EmployeeTableProps) {
  if (loading) {
    return (
      <div className="empty-state">
        <span className="loading-spinner"></span>
        <p style={{ marginTop: '1rem' }}>Loading employees...</p>
      </div>
    );
  }

  if (!employees.length) {
    return (
      <div className="empty-state">
        <p>✨ No employees yet. Create one to get started!</p>
      </div>
    );
  }

  return (
    <div className="table-wrapper">
      <table className="employee-table">
        <thead>
          <tr>
            <th>👤 Name</th>
            <th>📧 Email</th>
            <th>💼 Position</th>
            <th>📅 Hire Date</th>
            <th>💰 Salary</th>
            <th>✅ Status</th>
            <th>⚙️ Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td><strong>{`${employee.firstName} ${employee.lastName}`}</strong></td>
              <td>{employee.email}</td>
              <td>{employee.position || '—'}</td>
              <td>{employee.hireDate || '—'}</td>
              <td>${Number(employee.salary ?? 0).toFixed(2)}</td>
              <td>
                <span style={{
                  padding: '0.3rem 0.8rem',
                  borderRadius: '20px',
                  fontSize: '0.85rem',
                  fontWeight: 600,
                  background: employee.active ? 'rgba(102, 126, 234, 0.1)' : 'rgba(200, 200, 200, 0.2)',
                  color: employee.active ? '#667eea' : '#666'
                }}>
                  {employee.active ? '🟢 Active' : '⚪ Inactive'}
                </span>
              </td>
              <td className="actions-cell">
                <button type="button" onClick={() => onEdit(employee)} disabled={busy}>
                  Edit
                </button>
                <button
                  type="button"
                  className="button-danger"
                  onClick={() => void onDelete(employee.id)}
                  disabled={busy}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
