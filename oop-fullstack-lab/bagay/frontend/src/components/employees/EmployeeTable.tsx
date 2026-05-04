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
    return <p>Loading employees...</p>;
  }

  if (!employees.length) {
    return <p>No employees found.</p>;
  }

  return (
    <div className="table-wrapper">
      <table className="employee-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Position</th>
            <th>Hire Date</th>
            <th>Salary</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{`${employee.firstName} ${employee.lastName}`}</td>
              <td>{employee.email}</td>
              <td>{employee.position || 'N/A'}</td>
              <td>{employee.hireDate || 'N/A'}</td>
              <td>{Number(employee.salary ?? 0).toFixed(2)}</td>
              <td>{employee.active ? 'Active' : 'Inactive'}</td>
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
