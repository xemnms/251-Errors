import type { Student } from "../types/Student";

type Props = {
  students: Student[];
  onDelete: (id: number) => void;
};

export default function StudentList({ students, onDelete }: Props) {
  return (
    <div>
      {students.map((s) => (
        <div key={s.id}>
          <h3>{s.name}</h3>
          <p>{s.email}</p>
          <p>{s.course}</p>

          <button onClick={() => onDelete(s.id!)}>Delete</button>
        </div>
      ))}
    </div>
  );
}