package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.ObjectsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.pojo.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static ObjectsDAO studentsDAO = new StudentsDAO();

    public static List<String> isCorrectData(Map<String, String[]> incParam) {
        List<String> result = new ArrayList<>();
        if ((incParam.get("firstName") != null) && incParam.get("firstName")[0].equals(""))
            result.add("Invalid first name");
        if ((incParam.get("secondName") != null) && incParam.get("secondName")[0].equals(""))
            result.add("Invalid second name");
        try {
            if (incParam.get("courseId") != null)
                Integer.parseInt(incParam.get("courseId")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of course");
        }
        try {
            if (incParam.get("id") != null)
                Integer.parseInt(incParam.get("id")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of student");
        }
        return result;
    }

    public List<DBObject> getStudents(Map<String, String[]> incParam, String stopWord) {
        return studentsDAO.getAllByParam(incParam, stopWord);
    }

    public void addStudent(Map<String, String[]> incParam) {
        studentsDAO.addObject(incParam);
    }

    public void delStudent(Map<String, String[]> incParam) {
        studentsDAO.deleteObjectById(Integer.parseInt(incParam.get("id")[0]));
    }

    public void updateStudent(Map<String, String[]> incParam) {
        studentsDAO.updateObject(incParam);
    }
}
