package com.example.demo.services;

import com.example.demo.models.Subject;
import com.example.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    public Subject getSubjectById;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Integer id){
        return subjectRepository.findById(id);
    }

    public void postSubject (Subject subject){
        subjectRepository.save(subject);
    }
}
