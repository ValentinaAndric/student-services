package com.example.demo.controller;

import com.example.demo.models.Subject;
import com.example.demo.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectCtrl {
    private final SubjectService subjectService;
    @Autowired
    public SubjectCtrl(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }
}
