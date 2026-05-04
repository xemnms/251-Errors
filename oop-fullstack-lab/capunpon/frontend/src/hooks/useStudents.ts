import { useState, useEffect } from 'react'
import { Student } from '../types/Student'
import { studentService } from '../services/studentService'

export const useStudents = () => {
  const [students, setStudents] = useState<Student[]>([])
  const [loading, setLoading] = useState<boolean>(false)
  const [error, setError] = useState<string | null>(null)

  /**
   * Fetch all students when component mounts
   */
  const fetchStudents = async () => {
    setLoading(true)
    setError(null)
    try {
      const data = await studentService.getAllStudents()
      setStudents(data)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred')
    } finally {
      setLoading(false)
    }
  }

  /**
   * Add a new student to the list
   */
  const addStudent = async (student: Omit<Student, 'id'>) => {
    setLoading(true)
    setError(null)
    try {
      const newStudent = await studentService.createStudent(student)
      setStudents([...students, newStudent])
      return newStudent
    } catch (err) {
      const errorMsg = err instanceof Error ? err.message : 'An error occurred'
      setError(errorMsg)
      throw err
    } finally {
      setLoading(false)
    }
  }

  /**
   * Load students on mount
   */
  useEffect(() => {
    fetchStudents()
  }, [])

  return {
    students,
    loading,
    error,
    fetchStudents,
    addStudent,
  }
}
