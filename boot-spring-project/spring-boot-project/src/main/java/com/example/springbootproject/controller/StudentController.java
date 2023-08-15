package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Student;
import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.service.StudentService;
import com.example.springbootproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/student/{id}/reset-password")
    public Student resetStudentPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return studentService.updateStudentPassword(id, newPassword);
    }

    @GetMapping("/student/getAll")
    public List<Student> getAllTeachers(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/add")
    public Student add(Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(Student student,Long id){
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteById(Long id){
        studentService.getStudentById(id);
    }
}
