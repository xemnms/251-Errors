import { useState } from 'react';
import { useEmployees } from '../../hooks/useEmployees';
import type { Employee, EmployeePayload } from '../../types/Employee';
import { EmployeeForm } from './EmployeeForm';
import { EmployeeCards } from './EmployeeCards';

export function EmployeeManager() {
  const {
    employees,
    loading,
    saving,
    error,
    createEmployee,
    updateEmployee,
    deleteEmployee,
  } = useEmployees();

  const [editingEmployee, setEditingEmployee] = useState<Employee | null>(null);
  const [selectedCardId, setSelectedCardId] = useState<number | null>(null);

  const handleSubmit = async (payload: EmployeePayload) => {
    if (editingEmployee) {
      await updateEmployee(editingEmployee.id, payload);
      setEditingEmployee(null);
      return;
    }

    await createEmployee(payload);
  };

  const handleDelete = async (id: number) => {
    await deleteEmployee(id);
    if (editingEmployee?.id === id) {
      setEditingEmployee(null);
    }
    if (selectedCardId === id) {
      setSelectedCardId(null);
    }
  };

  return (
    <section className="employee-manager">
      {error ? <p className="error-banner">{error}</p> : null}

      <div className="employee-grid">
        <EmployeeForm
          initialEmployee={editingEmployee}
          isSubmitting={saving}
          onSubmit={handleSubmit}
          onCancelEdit={() => setEditingEmployee(null)}
        />

        <EmployeeCards
          employees={employees}
          loading={loading}
          selectedId={selectedCardId}
          onSelectCard={(employee) => setSelectedCardId(employee?.id ?? null)}
          onEdit={setEditingEmployee}
          onDelete={handleDelete}
          busy={saving}
        />
      </div>
    </section>
  );
}
