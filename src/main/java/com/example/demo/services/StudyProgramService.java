package com.example.demo.services;

import com.example.demo.models.StudyProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.StudyProgramRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;
    @Autowired
    public StudyProgramService(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }

    public List<StudyProgram> getAllStudyProgram (){
        return studyProgramRepository.findAll();
    }

    public Optional<StudyProgram> getStudyProgramById(Integer id){
       return studyProgramRepository.findById(id);
    }

    public void postStudyProgam(StudyProgram studyProgram){
        studyProgramRepository.save(studyProgram);
    }
}
