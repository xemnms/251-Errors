import { useState, useRef, useEffect } from "react";
import type { Student } from "../types/Student";
import {
  getStudents,
  createStudent,
  updateStudent as updateStudentApi,
  deleteStudent as deleteStudentApi,
} from "../services/studentService";

export const useStudents = () => {
  const [students, setStudents] = useState<Student[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const initialized = useRef(false);

  const loadStudents = async () => {
    try {
      const data = await getStudents();
      setStudents(data);
      setError(null);
    } catch {
      setError("Failed to load students.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    if (initialized.current) return;
    initialized.current = true;
    getStudents()
      .then(setStudents)
      .catch(() => setError("Failed to load students."))
      .finally(() => setLoading(false));
  }, []);

  const addStudent = async (student: Student) => {
    setError(null);
    try {
      await createStudent(student);
      await loadStudents();
    } catch {
      setError("Failed to add student.");
    }
  };

  const updateStudent = async (id: number, student: Student) => {
    setError(null);
    try {
      await updateStudentApi(id, student);
      await loadStudents();
    } catch {
      setError("Failed to update student.");
    }
  };

  const deleteStudent = async (id: number) => {
    setError(null);
    try {
      await deleteStudentApi(id);
      await loadStudents();
    } catch {
      setError("Failed to delete student.");
    }
  };

  return { students, loading, error, loadStudents, addStudent, updateStudent, deleteStudent };
};