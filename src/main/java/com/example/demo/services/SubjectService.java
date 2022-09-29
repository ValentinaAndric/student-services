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

    //Get all subject
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    //Get subject by id
    public Optional<Subject> getSubjectById(Integer id){
        return subjectRepository.findById(id);
    }

    //post subject
    public void postSubject (Subject subject){
        subjectRepository.save(subject);
    }

    //Delete subject
    public void deleteSubject (Integer id){
        subjectRepository.deleteById(id);
    }

    public void updateSubject (Integer id, String name, String description, Integer espb){
        Subject subject = subjectRepository.findById(id).orElseThrow(()-> new IllegalStateException("Subject with given id does not exists"));
        if(name!= null){
            subject.setName(name);
        }
        if(description!= null){
            subject.setDescription(description);
        }
        if(espb!= null){
            subject.setEspb(espb);
        }
        subjectRepository.save(subject);
    }
}
