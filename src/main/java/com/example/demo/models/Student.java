package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "numberofindex", nullable = false, length = 10)
    private String numberofindex;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studyprogram", nullable = false)
    private StudyProgram studyprogram;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberofindex() {
        return numberofindex;
    }

    public void setNumberofindex(String numberofindex) {
        this.numberofindex = numberofindex;
    }

    public StudyProgram getStudyprogram() {
        return studyprogram;
    }

    public void setStudyprogram(StudyProgram studyprogram) {
       this.studyprogram = studyprogram;
    }

}