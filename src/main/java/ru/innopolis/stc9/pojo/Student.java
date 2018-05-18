package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.CoursesDAOImpl;
import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Student extends DBObject {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private int courseId;
    private Course course;

    public Student() {
    }

    public Student(int id, String firstName, String secondName, String middleName, int courseId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.courseId = courseId;
    }

    public Student(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.firstName = resultSet.getString("firstName");
            this.secondName = resultSet.getString("secondName");
            this.middleName = resultSet.getString("middleName");
            this.courseId = resultSet.getInt("course");
            course = new CoursesDAOImpl().getCourseById(this.courseId);
        } catch (SQLException e) {
        }
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
    public Map<String, TypeOfGetSet> getDBOMethods() {
        Map<String, TypeOfGetSet> result = new HashMap<>();
        result.put("getFirstName",TypeOfGetSet.STRING);
        result.put("getSecondName",TypeOfGetSet.STRING);
        result.put("getMiddleName",TypeOfGetSet.STRING);
        result.put("getCourseId",TypeOfGetSet.INTEGER);
        result.put("getId",TypeOfGetSet.INTEGER);
        return result;
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
}


