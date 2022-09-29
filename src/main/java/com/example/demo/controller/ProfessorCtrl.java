package com.example.demo.controller;

import com.example.demo.models.Professor;
import com.example.demo.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorCtrl {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorCtrl(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessor(){
        return professorService.getAllProfessor();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable Integer id){
        return professorService.getProfessorById(id);
    }
    @PostMapping
    public void postProfessor(@RequestBody Professor professor){
        professorService.postProfessor(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Integer id){
        professorService.deleteProfessor(id);
    }

    @PutMapping("/{id}")
    public void updateProfessor(@PathVariable("id") Integer id, @RequestParam(required = false) String name,
                                @RequestParam(required = false) String surname, @RequestParam(required = false) String education){

        professorService.updateProfessor(id,name,surname,education);

    }
}
