import type { Student } from "../types/Student";

const BASE_URL = "https://fictional-yodel-5g7qr9j6wqrvhpg64-8080.app.github.dev/api/students";

export const getStudents = async (): Promise<Student[]> => {
  const res = await fetch(BASE_URL);
  if (!res.ok) throw new Error("Failed to fetch students");
  return res.json();
};

export const createStudent = async (student: Student): Promise<Student> => {
  const res = await fetch(BASE_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student),
  });
  if (!res.ok) throw new Error("Failed to create student");
  return res.json();
};

export const updateStudent = async (id: number, student: Student): Promise<Student> => {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student),
  });
  if (!res.ok) throw new Error("Failed to update student");
  return res.json();
};

export const deleteStudent = async (id: number): Promise<void> => {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE",
  });
  if (!res.ok) throw new Error("Failed to delete student");
};