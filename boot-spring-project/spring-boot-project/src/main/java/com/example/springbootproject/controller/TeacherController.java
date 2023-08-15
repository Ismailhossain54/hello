package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PutMapping("/teacher/{id}/reset-password")
    public Teacher resetTeacherPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return teacherService.updateTeacherPassword(id, newPassword);
    }

    @GetMapping("/teacher/getAll")
    public List<Teacher>getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Teacher findTeacherById(Long id){
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/teacher/add")
    public Teacher add(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/teacher/{id}")
    public Teacher updateTeacher(Teacher teacher,Long id){
        return teacherService.updateTeacher(teacher,id);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteById(Long id){
        teacherService.deleteTeacherById(id);
    }
}
