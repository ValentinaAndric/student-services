package com.example.demo.controller;

import com.example.demo.models.Professor;
import com.example.demo.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public void postProfessor(@RequestBody Professor professor){
        professorService.postProfessor(professor);
    }
}
