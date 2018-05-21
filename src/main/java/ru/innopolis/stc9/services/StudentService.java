package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.ObjectsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.pojo.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService implements ObjectService {
    private static ObjectsDAO objectsDAO = new StudentsDAO();

    public List<String> isCorrectData(Map<String, String[]> incParam) {
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

    public List<DBObject> getObjects(Map<String, String[]> incParam, String stopWord) {
        return objectsDAO.getAllByParam(incParam, stopWord);
    }

    public void addObject(Map<String, String[]> incParam) {
        objectsDAO.addObject(incParam);
    }

    public void delObject(Map<String, String[]> incParam) {
        objectsDAO.deleteObjectById(Integer.parseInt(incParam.get("id")[0]));
    }

    public void updateObject(Map<String, String[]> incParam) {
        objectsDAO.updateObject(incParam);
    }
}
