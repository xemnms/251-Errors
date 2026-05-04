import { useState } from "react";
import { Student } from "../types/Student";

type Props = {
  onAdd: (student: Student) => void;
};

export default function StudentForm({ onAdd }: Props) {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [course, setCourse] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onAdd({ name, email, course });
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

      <button type="submit">Add Student</button>
    </form>
  );
}