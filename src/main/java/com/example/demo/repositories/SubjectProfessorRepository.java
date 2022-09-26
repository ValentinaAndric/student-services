package com.example.demo.repositories;

import com.example.demo.models.SubjectProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectProfessorRepository extends JpaRepository<SubjectProfessor, Integer> {
}
