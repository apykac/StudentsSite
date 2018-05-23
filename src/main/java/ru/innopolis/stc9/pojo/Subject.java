package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.CoursesDAO;
import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject implements DBObject{
    private int id;
    private String name;
    private int courseId;
    private Course course;

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Map<String, TypeOfGetSet> getParamMap() {
        Map<String, TypeOfGetSet> result = new HashMap<>();
        result.put("id", TypeOfGetSet.INTEGER);
        result.put("name", TypeOfGetSet.STRING);
        result.put("course", TypeOfGetSet.INTEGER);
        return result;
    }

    @Override
    public List<Object[]> getDBOMethods(boolean isOrdered) {
        List<Object[]> result = new ArrayList<>();
        if (isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getName", TypeOfGetSet.STRING});
        result.add(new Object[]{"getCourseId", TypeOfGetSet.INTEGER});
        if (!isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        return result;
    }

    @Override
    public Subject getByResultSet(ResultSet resultSet) {
        Subject subject = new Subject();
        try {
            subject.setId(resultSet.getInt("id"));
            subject.setName(resultSet.getString("name"));
            subject.setCourseId(resultSet.getInt("course"));
            subject.setCourse(new CoursesDAO().getObjectById(subject.getCourseId()));
        } catch (SQLException e) {
        }
        return subject;
    }

    @Override
    public Subject getByParam(Map<String, String[]> incParam) {
        Subject subject = new Subject();
        if (incParam.get("id") != null) subject.setId(Integer.parseInt(incParam.get("id")[0]));
        subject.setName(incParam.get("name")[0]);
        subject.setCourseId(Integer.parseInt(incParam.get("courseId")[0]));
        return subject;
    }
}

