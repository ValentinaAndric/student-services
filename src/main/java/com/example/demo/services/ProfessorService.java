package com.example.demo.services;

import com.example.demo.models.Professor;
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
    //Update professor
    public void updateProfessor (Integer id, Professor newProfessor){
        Professor oldProfessor = professorRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with given id does not exists!"));
        if(newProfessor.getName() != null){
            oldProfessor.setName(newProfessor.getName());
        }
        if(newProfessor.getSurname() != null){
            oldProfessor.setSurname(newProfessor.getSurname());

        }
        if(newProfessor.getEducation() != null){
            oldProfessor.setEducation(newProfessor.getEducation());
        }
        professorRepository.save(oldProfessor);
    }
}

