package com.badosa.student_list.service;

import com.badosa.student_list.dto.StudentDTO;
import com.badosa.student_list.exception.StudentNotFoundException;
import com.badosa.student_list.model.Student;
import com.badosa.student_list.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDTO> getAllStudents() {
        return repository.findAll().stream()
                .map(StudentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return StudentDTO.fromEntity(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentDTO.toEntity();
        Student saved = repository.save(student);
        return StudentDTO.fromEntity(saved);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        existing.setFirstName(studentDTO.getFirstName());
        existing.setLastName(studentDTO.getLastName());
        existing.setEmail(studentDTO.getEmail());
        existing.setCourse(studentDTO.getCourse());

        Student updated = repository.save(existing);
        return StudentDTO.fromEntity(updated);
    }

    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
