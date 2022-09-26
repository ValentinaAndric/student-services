package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "subjectprofessor")
public class SubjectProfessor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private SubjectProfessorId id;

    @MapsId("professor")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professor", nullable = false)
    private Professor professor;

    public SubjectProfessorId getId() {
        return id;
    }

    public void setId(SubjectProfessorId id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}