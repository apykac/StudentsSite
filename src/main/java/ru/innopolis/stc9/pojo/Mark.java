package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.LessonsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mark implements DBObject{
    private int id;
    private int studentId;
    private Student student;
    private int lessonId;
    private Lesson lesson;
    private int value;

    public Mark() {
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

    @Override
    public Map<String, TypeOfGetSet> getParamMap() {
        Map<String, TypeOfGetSet> result = new HashMap<>();
        result.put("id", TypeOfGetSet.INTEGER);
        result.put("student", TypeOfGetSet.INTEGER);
        result.put("lesson", TypeOfGetSet.INTEGER);
        result.put("value", TypeOfGetSet.INTEGER);
        return result;
    }

    @Override
    public List<Object[]> getDBOMethods(boolean isOrdered) {
        List<Object[]> result = new ArrayList<>();
        if (isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getStudentId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getLessonId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getValue", TypeOfGetSet.INTEGER});
        if (!isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        return result;
    }

    @Override
    public Mark getByResultSet(ResultSet resultSet) {
        Mark mark = new Mark();
        try {
            mark.setId(resultSet.getInt("id"));
            mark.setStudentId(resultSet.getInt("student"));
            mark.setLessonId(resultSet.getInt("lesson"));
            mark.setValue(resultSet.getInt("value"));
            mark.setStudent(new StudentsDAO().getObjectById(mark.getStudentId()));
            mark.setLesson(new LessonsDAO().getObjectById(mark.getLessonId()));
        } catch (SQLException e) {
        }
        return mark;
    }

    @Override
    public Mark getByParam(Map<String, String[]> incParam) {
        Mark mark = new Mark();
        if (incParam.get("id") != null) mark.setId(Integer.parseInt(incParam.get("id")[0]));
        mark.setStudentId(Integer.parseInt(incParam.get("studentId")[0]));
        mark.setLessonId(Integer.parseInt(incParam.get("lessonId")[0]));
        mark.setValue(Integer.parseInt(incParam.get("value")[0]));
        return mark;
    }
}
