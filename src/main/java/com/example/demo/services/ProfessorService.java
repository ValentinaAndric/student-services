package com.example.demo.services;

import com.example.demo.models.Professor;
import com.example.demo.models.Student;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateProfessor (Integer id, Professor professor){
        Professor prf = professorRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with given id does not exists!"));
        if(professor.getName() != null){
            prf.setName(professor.getName());
        }
        if(professor.getSurname() != null){
            prf.setSurname(professor.getSurname());
        }
        if(professor.getEducation() != null){
            prf.setEducation(professor.getEducation());
        }
        professorRepository.save(prf);
    }
}

