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
    public void updataStudyProgram(Integer id, StudyProgram newStudyProgram){
       StudyProgram oldStudyProgram = studyProgramRepository.findById(id).orElseThrow(()-> new IllegalStateException("Study program with given id does not exist"));
       if(newStudyProgram.getName() != null){
           oldStudyProgram.setName(newStudyProgram.getName());
       }
       if(newStudyProgram.getDuration()!= null){
           oldStudyProgram.setDuration(newStudyProgram.getDuration());
       }
       if(newStudyProgram.getDescription()!= null){
           oldStudyProgram.setDescription(newStudyProgram.getDescription());
       }

       studyProgramRepository.save(oldStudyProgram);

    }
}
