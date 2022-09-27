package com.example.demo.controller;

import com.example.demo.models.StudyProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.StudyProgramService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/studyProgram")
public class StudyProgramCtrl {

    private final StudyProgramService studyProgramService;

    @Autowired
    public StudyProgramCtrl(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping
    public List<StudyProgram> getAllStudyProgram(){
        return studyProgramService.getAllStudyProgram();
    }

    @GetMapping("/{id}")
    public Optional<StudyProgram> getStudyProgramById(@PathVariable  Integer id){
        return studyProgramService.getStudyProgramById(id);
    }
    @PostMapping
    public void postStudyProgram(@RequestBody StudyProgram studyProgram){
        studyProgramService.postStudyProgam(studyProgram);
    }
}
