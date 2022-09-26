package com.example.demo.controller;

import com.example.demo.models.StudentSubject;
import com.example.demo.services.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentSubject")
public class StudentSubjectCtrl {
    private final StudentSubjectService studentSubjectService;

    @Autowired
    public StudentSubjectCtrl(StudentSubjectService studentSubjectService) {
        this.studentSubjectService = studentSubjectService;
    }

    public List<StudentSubject> getAllStudentSubject(){
        return studentSubjectService.getAllStudentSubject();
    }
}
