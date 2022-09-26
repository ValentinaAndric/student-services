package com.example.demo.services;

import com.example.demo.models.StudentSubject;
import com.example.demo.repositories.StudentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSubjectService {
    private final StudentSubjectRepository studentSubjectRepository;

    @Autowired
    public StudentSubjectService(StudentSubjectRepository studentSubjectRepository) {
        this.studentSubjectRepository = studentSubjectRepository;
    }

    public List<StudentSubject> getAllStudentSubject(){
        return studentSubjectRepository.findAll();
    }
}
