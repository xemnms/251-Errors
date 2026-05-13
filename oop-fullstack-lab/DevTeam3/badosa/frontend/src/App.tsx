import { useState } from 'react'
import StudentForm from './components/StudentForm'
import StudentList from './components/StudentList'
import { useStudents } from './hooks/useStudents'
import type { Student } from './types/Student'
import './App.css'

function App() {
  const { students, loading, error, addStudent, deleteStudent, updateStudent } = useStudents()
  const [editingStudent, setEditingStudent] = useState<Student | null>(null)

  return (
    <div className="app">
      <header className="app-header">
        <h1>Student Registry</h1>
        <span className="badge">{students.length} enrolled</span>
      </header>

      {error && <div className="error-banner">{error}</div>}

      <main className="app-main">
        <section className="form-section">
          <h2>{editingStudent ? "Edit Student" : "Add Student"}</h2>
          <StudentForm
            key={editingStudent?.id ?? 'new'}
            onAdd={addStudent}
            onUpdate={updateStudent}
            editingStudent={editingStudent}
            onCancelEdit={() => setEditingStudent(null)}
          />
        </section>

        <section className="list-section">
          <h2>Students</h2>
          {loading ? (
            <div className="loading">Loading...</div>
          ) : (
            <StudentList
              students={students}
              onDelete={deleteStudent}
              onEdit={setEditingStudent}
            />
          )}
        </section>
      </main>
    </div>
  )
}

export default App