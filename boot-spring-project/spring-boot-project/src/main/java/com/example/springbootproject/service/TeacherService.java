package com.example.springbootproject.service;

import com.example.springbootproject.domain.Teacher;
import com.example.springbootproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher>getAllTeachers(){
        return teacherRepository.findAll();
    }

    public  Teacher getTeacherById(Long id){
        return teacherRepository.findById(id).orElse(null);
    }

    public  Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher,Long id){

        Teacher oldInformation=teacherRepository.findById(id).orElse(null);
        oldInformation.setId(id);
        oldInformation.setName(teacher.getName());
        oldInformation.setPhone(teacher.getPhone());
        oldInformation.setEmail(teacher.getEmail());
        oldInformation.setDepartmentName(teacher.getDepartmentName());
        return teacherRepository.save(oldInformation);
    }

    public void deleteTeacherById(Long id){
        teacherRepository.deleteById(id);
    }


    public Teacher updateTeacherPassword(Long id, String newPassword) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setPassword(newPassword);
            return teacherRepository.save(teacher);
        }
        return null;
    }

}
