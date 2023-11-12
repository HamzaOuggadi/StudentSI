package net.hamzaouggadi.studentsi.controller;

import lombok.RequiredArgsConstructor;
import net.hamzaouggadi.studentsi.entities.Student;
import net.hamzaouggadi.studentsi.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/byId/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> checkStudentByEmailIfExists(@PathVariable String email) {
        return ResponseEntity.ok(studentService.studentExistsByEmail(email));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student Added Successfully.");
    }

    @DeleteMapping("/deleteById{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok("Student Deleted Successfully.");
    }
}
