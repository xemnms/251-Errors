import type { Employee } from '../../types/Employee';
import './EmployeeCards.css';

type EmployeeCardsProps = {
  employees: Employee[];
  loading: boolean;
  selectedId: number | null;
  onSelectCard: (employee: Employee | null) => void;
  onEdit: (employee: Employee) => void;
  onDelete: (id: number) => Promise<void>;
  busy: boolean;
};

export function EmployeeCards({
  employees,
  loading,
  selectedId,
  onSelectCard,
  onEdit,
  onDelete,
  busy,
}: EmployeeCardsProps) {
  if (loading) {
    return (
      <div className="cards-container loading-state">
        <span className="loading-spinner"></span>
        <p>Loading employees...</p>
      </div>
    );
  }

  if (!employees.length) {
    return (
      <div className="cards-container empty-state">
        <p>✨ No employees yet. Create one to get started!</p>
      </div>
    );
  }

  return (
    <div className="cards-container">
      {employees.map((employee) => (
        <div key={employee.id} className="card-wrapper">
          <div
            className={`employee-card ${selectedId === employee.id ? 'selected' : ''}`}
            onClick={() => onSelectCard(selectedId === employee.id ? null : employee)}
          >
            <div className="card-header">
              <div className="employee-avatar">
                {employee.firstName.charAt(0).toUpperCase()}
                {employee.lastName.charAt(0).toUpperCase()}
              </div>
              <div className="card-title">
                <h3>{`${employee.firstName} ${employee.lastName}`}</h3>
                <p className="card-position">{employee.position || 'No position'}</p>
              </div>
              {employee.active ? (
                <span className="status-badge active">🟢</span>
              ) : (
                <span className="status-badge inactive">⚪</span>
              )}
            </div>

            <div className="card-content">
              <div className="info-row">
                <span className="info-label">📧 Email</span>
                <span className="info-value">{employee.email}</span>
              </div>

              {employee.hireDate && (
                <div className="info-row">
                  <span className="info-label">📅 Hired</span>
                  <span className="info-value">{employee.hireDate}</span>
                </div>
              )}

              <div className="info-row">
                <span className="info-label">💰 Salary</span>
                <span className="info-value salary">${Number(employee.salary ?? 0).toFixed(2)}</span>
              </div>
            </div>

            {selectedId === employee.id && (
              <div className="card-actions">
                <button
                  className="action-button edit"
                  onClick={(e) => {
                    e.stopPropagation();
                    onEdit(employee);
                  }}
                  disabled={busy}
                >
                  ✏️ Edit
                </button>
                <button
                  className="action-button delete"
                  onClick={(e) => {
                    e.stopPropagation();
                    void onDelete(employee.id);
                  }}
                  disabled={busy}
                >
                  🗑️ Delete
                </button>
              </div>
            )}
          </div>
        </div>
      ))}
    </div>
  );
}
