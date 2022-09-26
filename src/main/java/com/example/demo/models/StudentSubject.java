package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "studentsubject")
public class StudentSubject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private StudentSubjectId id;

    @MapsId("student")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @MapsId("subject")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject", nullable = false)
    private Subject subject;

    public StudentSubjectId getId() {
        return id;
    }

    public void setId(StudentSubjectId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}