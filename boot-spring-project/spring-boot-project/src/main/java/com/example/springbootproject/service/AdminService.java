package com.example.springbootproject.service;

import com.example.springbootproject.domain.Admin;
import com.example.springbootproject.domain.Student;
import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.repository.AdminRepository;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository,TeacherRepository teacherRepository,StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.teacherRepository=teacherRepository;
        this.studentRepository=studentRepository;
    }

    public List<Teacher>getAllTeachers(){
        return teacherRepository.findAll();
    }

    public  List<Student>getAllStudents(){
        return studentRepository.findAll();
    }

    public  Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

}
