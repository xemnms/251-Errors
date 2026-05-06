import { useState } from "react";
import type { Student } from "../types/Student";

type Props = {
  onAdd: (student: Student) => Promise<void>;
  onUpdate: (id: number, student: Student) => Promise<void>;
  editingStudent: Student | null;
  onCancelEdit: () => void;
};

export default function StudentForm({ onAdd, onUpdate, editingStudent, onCancelEdit }: Props) {
  const [name, setName] = useState(editingStudent?.name ?? "");
  const [email, setEmail] = useState(editingStudent?.email ?? "");
  const [course, setCourse] = useState(editingStudent?.course ?? "");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!name.trim() || !email.trim() || !course.trim()) {
      alert("Please fill in all fields!");
      return;
    }
    if (editingStudent) {
      await onUpdate(editingStudent.id!, { name: name.trim(), email: email.trim(), course: course.trim() });
    } else {
      await onAdd({ name: name.trim(), email: email.trim(), course: course.trim() });
    }
    setName("");
    setEmail("");
    setCourse("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Name" value={name}
        onChange={(e) => setName(e.target.value)} />
      <input placeholder="Email" value={email}
        onChange={(e) => setEmail(e.target.value)} />
      <input placeholder="Course" value={course}
        onChange={(e) => setCourse(e.target.value)} />
      <button type="submit">{editingStudent ? "Update Student" : "Add Student"}</button>
      {editingStudent && (
        <button type="button" onClick={onCancelEdit} style={{marginTop: '8px', background: 'transparent', color: 'var(--text-muted)', border: '1px solid var(--border)'}}>
          Cancel
        </button>
      )}
    </form>
  );
}