import type { Student } from "../types/Student";

type Props = {
  students: Student[];
  onDelete: (id: number) => Promise<void>;
  onEdit: (student: Student) => void;
};

export default function StudentList({ students, onDelete, onEdit }: Props) {
  if (students.length === 0) {
    return <p className="empty-state">No students yet — add one!</p>
  }

  return (
    <div className="student-list">
      {students.map((s) => (
        <div key={s.id} className="student-card">
          <div className="student-info">
            <h3>{s.name}</h3>
            <p>{s.email}</p>
            <span className="course-tag">{s.course}</span>
          </div>
          <div style={{display:'flex', gap:'8px'}}>
            <button className="delete-btn" onClick={() => onEdit(s)}>
              Edit
            </button>
            <button className="delete-btn" onClick={() => onDelete(s.id!)}>
              Remove
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}