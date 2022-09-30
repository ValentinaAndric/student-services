package com.example.demo.controller;

import com.example.demo.models.Subject;
import com.example.demo.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Subject> getSubjectById(@PathVariable  Integer id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public void postSubject(@RequestBody Subject subject){
        subjectService.postSubject(subject);
    }
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id){
        subjectService.deleteSubject(id);
    }
    @PutMapping("/{id}")
    public void updateSubject(@PathVariable("id")Integer id, @RequestBody Subject subject){
        subjectService.updateSubject(id, subject);
    }
}
