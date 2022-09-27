package com.example.demo.services;

import com.example.demo.models.Student;
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
}

