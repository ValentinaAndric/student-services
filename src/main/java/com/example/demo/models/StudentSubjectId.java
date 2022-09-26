package com.example.demo.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentSubjectId implements Serializable {
    private static final long serialVersionUID = -1680522402517705598L;
    @Column(name = "student", nullable = false)
    private Integer student;

    @Column(name = "subject", nullable = false)
    private Integer subject;

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
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
        StudentSubjectId entity = (StudentSubjectId) o;
        return Objects.equals(this.student, entity.student) &&
                Objects.equals(this.subject, entity.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, subject);
    }

}