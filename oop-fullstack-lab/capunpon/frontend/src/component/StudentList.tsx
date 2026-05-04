import { useState } from 'react'
import { useStudents } from '../hooks/useStudents'
import { Student } from '../types/Student'
import './StudentList.css'

export const StudentList = () => {
  const { students, loading, error, addStudent } = useStudents()
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    course: '',
  })
  const [isSubmitting, setIsSubmitting] = useState(false)

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }))
  }

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault()
    setIsSubmitting(true)

    try {
      await addStudent({
        firstName: formData.firstName,
        lastName: formData.lastName,
        email: formData.email,
        course: formData.course,
      })

      // Reset form
      setFormData({
        firstName: '',
        lastName: '',
        email: '',
        course: '',
      })
    } catch (err) {
      console.error('Failed to add student:', err)
    } finally {
      setIsSubmitting(false)
    }
  }

  if (loading && students.length === 0) {
    return <div className="student-list">Loading students...</div>
  }

  return (
    <div className="student-list">
      <h1>Student Management</h1>

      {error && <div className="error-message">{error}</div>}

      <form onSubmit={handleSubmit} className="student-form">
        <h2>Add New Student</h2>
        <div className="form-group">
          <input
            type="text"
            name="firstName"
            placeholder="First Name"
            value={formData.firstName}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <input
            type="text"
            name="lastName"
            placeholder="Last Name"
            value={formData.lastName}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={formData.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <input
            type="text"
            name="course"
            placeholder="Course"
            value={formData.course}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit" disabled={isSubmitting}>
          {isSubmitting ? 'Adding...' : 'Add Student'}
        </button>
      </form>

      <div className="students-section">
        <h2>Students ({students.length})</h2>
        {students.length === 0 ? (
          <p>No students found</p>
        ) : (
          <table className="students-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Course</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student: Student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.firstName}</td>
                  <td>{student.lastName}</td>
                  <td>{student.email}</td>
                  <td>{student.course}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}
