package ru.innopolis.stc9.pojo;

import java.sql.Date;

public class Lesson {
    private int id;
    private int subjectId;
    private Subject subject;
    private Date begin;
    private Date end;

    public Lesson(int id, int subjectId, Date begin, Date end) {
        this.id = id;
        this.subjectId = subjectId;
        this.begin = begin;
        this.end = end;
    }

    public Lesson(int id, Subject subject, Date begin, Date end) {
        this.id = id;
        this.subject = subject;
        this.begin = begin;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
