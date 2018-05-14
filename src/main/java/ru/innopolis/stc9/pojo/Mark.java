package ru.innopolis.stc9.pojo;

public class Mark {
    private int id;
    private int studentId;
    private Student student;
    private int lessonId;
    private Lesson lesson;
    private int value;

    public Mark(int id, int studentId, int lessonId, int value) {
        this.id = id;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.value = value;
    }

    public Mark(int id, Student student, Lesson lesson, int value) {
        this.id = id;
        this.student = student;
        this.lesson = lesson;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
