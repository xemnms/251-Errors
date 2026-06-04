export interface Employee {
  id: number;
  name: string;
  email: string;
  department: string;
  jobTitle: string;
  salary: number;
}

export type EmployeePayload = Omit<Employee, 'id'>;
