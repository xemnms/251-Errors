import type { Student } from "../types/Student";

const BASE_URL = "http://localhost:8080/api/students";

export const getStudents = async (): Promise<Student[]> => {
  const res = await fetch(BASE_URL);
  return res.json();
};

export const createStudent = async (student: Student) => {
  await fetch(BASE_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student),
  });
};

export const updateStudent = async (id: number, student: Student) => {
  await fetch(`${BASE_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student),
  });
};

export const deleteStudent = async (id: number) => {
  await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE",
  });
};