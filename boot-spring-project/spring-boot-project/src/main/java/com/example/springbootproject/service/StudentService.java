package com.example.springbootproject.service;

import com.example.springbootproject.domain.Student;
import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public  Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public  Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student,Long id){

        Student oldInformation= studentRepository.findById(id).orElse(null);
        oldInformation.setId(id);
        oldInformation.setName(student.getName());
        oldInformation.setPhone(student.getPhone());
        oldInformation.setEmail(student.getEmail());
        oldInformation.setDepartmentName(student.getDepartmentName());
        return studentRepository.save(oldInformation);
    }

    public void deleteTeacherById(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudentPassword(Long id, String newPassword) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setPassword(newPassword);
            return studentRepository.save(student);
        }
        return null;
    }
}
