package net.hamzaouggadi.studentsi.services;

import net.hamzaouggadi.studentsi.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    Boolean studentExistsByEmail(String email);
    void addStudent(Student student);
    void deleteStudentById(Long studentId);
}
