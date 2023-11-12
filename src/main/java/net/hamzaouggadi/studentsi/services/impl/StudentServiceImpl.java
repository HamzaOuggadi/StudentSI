package net.hamzaouggadi.studentsi.services.impl;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.studentsi.entities.Student;
import net.hamzaouggadi.studentsi.exceptions.StudentBadRequestException;
import net.hamzaouggadi.studentsi.exceptions.StudentNotFoundException;
import net.hamzaouggadi.studentsi.repositories.StudentRepository;
import net.hamzaouggadi.studentsi.services.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new StudentNotFoundException("Student Not Found.");
        }
    }

    @Override
    public Boolean studentExistsByEmail(String email) {
        return studentRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        } else {
            throw new StudentBadRequestException("The given ID doesn't correspond to a student on the database.");
        }

    }

}
