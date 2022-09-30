package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.models.StudyProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Get all student
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    //Get student by id
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }
    //Post student
    public void postStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
         studentRepository.deleteById(id);
    }
    public void updateStudent(Integer id, Student newStudent){
        Student oldStudent = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with given id does not exists"));
        if (newStudent.getName()!=null){
            oldStudent.setName(newStudent.getName());
        }
        if(newStudent.getSurname()!=null){
            oldStudent.setSurname(newStudent.getSurname());
        }
        if(newStudent.getNumberofindex()!= null){
            oldStudent.setNumberofindex(newStudent.getNumberofindex());
        }
        if(newStudent.getStudyprogram() != null){
            oldStudent.setStudyprogram(newStudent.getStudyprogram());
        }
        studentRepository.save(oldStudent);


    }
}

