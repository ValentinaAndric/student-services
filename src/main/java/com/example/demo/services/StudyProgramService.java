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
    //Get all study program
    public List<StudyProgram> getAllStudyProgram (){
        return studyProgramRepository.findAll();
    }

    //Get study program by id
    public Optional<StudyProgram> getStudyProgramById(Integer id){
       return studyProgramRepository.findById(id);
    }

    //Post study program
    public void postStudyProgam(StudyProgram studyProgram){
        studyProgramRepository.save(studyProgram);
    }

    //Delete study program
    public void deleteStudyProgram(Integer id){
        studyProgramRepository.deleteById(id);
    }
    //Update study program
    public void updataStudyProgram(Integer id, String name, Integer duration, String description){
       StudyProgram studyProgram = studyProgramRepository.findById(id).orElseThrow(()-> new IllegalStateException("Study program with given id does not exist"));
       if(name!= null){
           studyProgram.setName(name);
       }
       if(duration != null){
           studyProgram.setDuration(duration);
       }
       if(description != null){
           studyProgram.setDescription(description);
       }
       studyProgramRepository.save(studyProgram);
    }
}
