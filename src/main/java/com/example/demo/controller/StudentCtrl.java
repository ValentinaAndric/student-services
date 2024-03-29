package com.example.demo.controller;

import com.example.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentCtrl {
    private final StudentService studentService;

    @Autowired
    public StudentCtrl(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void postStudent(@RequestBody Student student){
        studentService.postStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent (@PathVariable("id") Integer id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }
    @GetMapping("subj/{id}")
    public List<Student> getAllStudentBySubject(@PathVariable("id") Integer subject){
       return studentService.getAllStudentBySubject(subject);
    }
}
