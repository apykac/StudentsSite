package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.SubjectsDAO;
import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson implements DBObject {
    private int id;
    private int subjectId;
    private Subject subject;
    private Date begin;
    private Date end;

    public Lesson() {
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

    @Override
    public Map<String, TypeOfGetSet> getParamMap() {
        Map<String, TypeOfGetSet> result = new HashMap<>();
        result.put("id", TypeOfGetSet.INTEGER);
        result.put("subject", TypeOfGetSet.INTEGER);
        result.put("begin", TypeOfGetSet.DATE);
        result.put("end", TypeOfGetSet.DATE);
        return result;
    }

    @Override
    public List<Object[]> getDBOMethods(boolean isOrdered) {
        List<Object[]> result = new ArrayList<>();
        if (isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getSubjectId", TypeOfGetSet.INTEGER});
        result.add(new Object[]{"getBegin", TypeOfGetSet.DATE});
        result.add(new Object[]{"getEnd", TypeOfGetSet.DATE});
        if (!isOrdered) result.add(new Object[]{"getId", TypeOfGetSet.INTEGER});
        return result;
    }

    @Override
    public Lesson getByResultSet(ResultSet resultSet) {
        Lesson lesson = new Lesson();
        try {
            lesson.setId(resultSet.getInt("id"));
            lesson.setSubjectId(resultSet.getInt("subject"));
            lesson.setBegin(resultSet.getDate("begin"));
            lesson.setEnd(resultSet.getDate("end"));
            lesson.setSubject(new SubjectsDAO().getObjectById(lesson.subjectId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesson;
    }

    @Override
    public Lesson getByParam(Map<String, String[]> incParam) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd/HH:mm");
        java.util.Date parsed;
        Lesson lesson = new Lesson();
        try {
            if (incParam.get("id") != null) lesson.setId(Integer.parseInt(incParam.get("id")[0]));
            lesson.setSubjectId(Integer.parseInt(incParam.get("subject")[0]));
            parsed = format.parse(incParam.get("begin")[0]);
            lesson.setBegin(new Date(parsed.getTime()));
            parsed = format.parse(incParam.get("end")[0]);
            lesson.setEnd(new Date(parsed.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lesson;
    }
}
