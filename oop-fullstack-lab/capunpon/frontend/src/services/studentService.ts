import { Student } from '../types/Student'

const API_BASE_URL = 'http://localhost:8080/api/students'

export const studentService = {
  /**
   * Fetch all students from the backend
   */
  async getAllStudents(): Promise<Student[]> {
    const response = await fetch(API_BASE_URL)
    if (!response.ok) {
      throw new Error(`Failed to fetch students: ${response.statusText}`)
    }
    return response.json()
  },

  /**
   * Create a new student
   */
  async createStudent(student: Omit<Student, 'id'>): Promise<Student> {
    const response = await fetch(API_BASE_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(student),
    })
    if (!response.ok) {
      throw new Error(`Failed to create student: ${response.statusText}`)
    }
    return response.json()
  },
}
