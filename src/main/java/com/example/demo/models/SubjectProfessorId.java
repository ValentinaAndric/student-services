package com.example.demo.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubjectProfessorId implements Serializable {
    private static final long serialVersionUID = -3167798543743950613L;
    @Column(name = "professor", nullable = false)
    private Integer professor;

    @Column(name = "subject", nullable = false)
    private Integer subject;

    public Integer getProfessor() {
        return professor;
    }

    public void setProfessor(Integer professor) {
        this.professor = professor;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubjectProfessorId entity = (SubjectProfessorId) o;
        return Objects.equals(this.professor, entity.professor) &&
                Objects.equals(this.subject, entity.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor, subject);
    }

}