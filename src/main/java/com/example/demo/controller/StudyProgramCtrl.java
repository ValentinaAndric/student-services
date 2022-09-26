package com.example.demo.controller;

import com.example.demo.models.StudyProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.StudyProgramService;

import java.util.List;

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
}
