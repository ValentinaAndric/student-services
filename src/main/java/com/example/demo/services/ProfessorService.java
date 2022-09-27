package com.example.demo.services;

import com.example.demo.models.Professor;
import com.example.demo.models.Student;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    //Dependency injection
    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    //Get all professor
    public List<Professor> getAllProfessor(){
        return professorRepository.findAll();
    }
    //Get professor by id
    public Optional<Professor> getProfessorById(Integer id){
        return professorRepository.findById(id);
    }
    //Post professor
    public void postProfessor(Professor professor){
        professorRepository.save(professor);
    }
    //Delete professor
    public void deleteProfessor (Integer id){
        professorRepository.deleteById(id);
    }

    public void updateProfessor (Integer id, String name, String surname, String education){
        Optional<Professor> oldProfessor = professorRepository.findById(id);
        oldProfessor.ifPresent(professor -> {professor.setName(name);
        professor.setSurname(surname); professor.setEducation(education);
        professorRepository.save(professor);});


    }
}

