package ru.innopolis.stc9.pojo;


import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сущность курс. Направление обучения студентов
 */
public class Course implements DBObject {
    private int id;
    private String name;

    public Course() {
    }

    @Override
    public Map<String, TypeOfGetSet> getParamMap() {
        Map<String, TypeOfGetSet> result = new HashMap<>();
        result.put("id", TypeOfGetSet.INTEGER);
        result.put("name", TypeOfGetSet.STRING);
        return result;
    }

    @Override
    public List<Object[]> getDBOMethods(boolean isOrdered) {
        List<Object[]> result = new ArrayList<>();
        if (isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getName", TypeOfGetSet.STRING});
        if (!isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        return result;
    }

    @Override
    public Course getByResultSet(ResultSet resultSet) {
        Course course = new Course();
        try {
            course.setId(resultSet.getInt("id"));
            course.setName(resultSet.getString("name"));
        } catch (SQLException e) {
        }
        return course;
    }

    @Override
    public Course getByParam(Map<String, String[]> incParam) {
        Course course = new Course();
        if (incParam.get("id") != null) course.setId(Integer.parseInt(incParam.get("id")[0]));
        course.setName(incParam.get("name")[0]);
        return course;
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
}
