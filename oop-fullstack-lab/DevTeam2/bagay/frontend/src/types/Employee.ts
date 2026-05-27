export interface Employee {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    position: string;
    hireDate: string;
    salary: number;
    active: boolean;
}

export type EmployeePayload = Omit<Employee, 'id'>;