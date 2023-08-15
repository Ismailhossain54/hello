package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Admin;
import com.example.springbootproject.domain.Student;
import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/teachers")
    public List<Teacher>findAllTeachers(){
        return adminService.getAllTeachers();
    }

    @GetMapping("/admin/students")
    public List<Student>findAllStudents(){
        return adminService.getAllStudents();
    }

    @PostMapping("/admin/add")
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }
}
