import { useEffect, useState } from 'react';
import type { Employee, EmployeePayload } from '../types/Employee';

const DEFAULT_FORM: EmployeePayload = {
  firstName: '',
  lastName: '',
  email: '',
  position: '',
  hireDate: '',
  salary: 0,
  active: true,
};

export function useEmployeeForm(initialEmployee?: Employee | null) {
  const [formValues, setFormValues] = useState<EmployeePayload>(
    initialEmployee ? toPayload(initialEmployee) : DEFAULT_FORM,
  );

  useEffect(() => {
    setFormValues(initialEmployee ? toPayload(initialEmployee) : DEFAULT_FORM);
  }, [initialEmployee]);

  const updateField = <K extends keyof EmployeePayload>(
    key: K,
    value: EmployeePayload[K],
  ) => {
    setFormValues((current) => ({ ...current, [key]: value }));
  };

  const reset = () => setFormValues(DEFAULT_FORM);

  return {
    formValues,
    updateField,
    reset,
  };
}

function toPayload(employee: Employee): EmployeePayload {
  const { id: _ignoredId, ...payload } = employee;
  return payload;
}
