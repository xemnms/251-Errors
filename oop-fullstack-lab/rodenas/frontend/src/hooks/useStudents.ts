import { useEffect, useState } from "react";
import type { Student } from "../types/Student";
import { getStudents } from "../services/studentService";

export function useStudents() {
  const [students, setStudents] = useState<Student[]>([]);

  const loadStudents = async () => {
    const data = await getStudents();
    setStudents(data);
  };

  useEffect(() => {
    const fetchData = async () => {
      await loadStudents();
    };

    fetchData();
  }, []);

  return { students, loadStudents };
}