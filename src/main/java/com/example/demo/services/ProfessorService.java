package com.example.demo.services;

import com.example.demo.models.Professor;
import com.example.demo.models.Student;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessor(){
        return professorRepository.findAll();
    }

    public void postProfessor(Professor professor){
        professorRepository.save(professor);
    }
}

