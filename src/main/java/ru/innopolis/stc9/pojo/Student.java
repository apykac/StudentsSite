package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.CoursesDAO;
import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements DBObject {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private int courseId;
    private Course course;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
        result.put("firstName", TypeOfGetSet.STRING);
        result.put("secondName", TypeOfGetSet.STRING);
        result.put("middleName", TypeOfGetSet.STRING);
        result.put("course", TypeOfGetSet.INTEGER);
        return result;
    }

    @Override
    public List<Object[]> getDBOMethods(boolean isOrdered) {
        List<Object[]> result = new ArrayList<>();
        if (isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getFirstName", TypeOfGetSet.STRING});
        result.add(new Object[]{"getSecondName", TypeOfGetSet.STRING});
        result.add(new Object[]{"getMiddleName", TypeOfGetSet.STRING});
        result.add(new Object[]{"getCourseId", TypeOfGetSet.INTEGER});
        if (!isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        return result;
    }

    @Override
    public Student getByResultSet(ResultSet resultSet) {
        Student student = new Student();
        try {
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setSecondName(resultSet.getString("secondName"));
            student.setMiddleName(resultSet.getString("middleName"));
            student.setCourseId(resultSet.getInt("course"));
            student.setCourse(new CoursesDAO().getObjectById(student.getCourseId()));
        } catch (SQLException e) {
        }
        return student;
    }

    @Override
    public Student getByParam(Map<String, String[]> incParam) {
        Student student = new Student();
        if (incParam.get("id") != null) student.setId(Integer.parseInt(incParam.get("id")[0]));
        student.setFirstName(incParam.get("firstName")[0]);
        student.setSecondName(incParam.get("secondName")[0]);
        student.setMiddleName(incParam.get("middleName")[0]);
        student.setCourseId(Integer.parseInt(incParam.get("courseId")[0]));
        return student;
    }
}


