package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.MarksDAO;
import ru.innopolis.stc9.db.dao.ObjectsDAO;
import ru.innopolis.stc9.pojo.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Сервис оценок
 */
public class MarkService implements ObjectService {
    ObjectsDAO objectsDAO = new MarksDAO();

    public List<String> isCorrectData(Map<String, String[]> incParam) {
        List<String> result = new ArrayList<>();
        if (incParam == null || incParam.isEmpty()) return result;
        int value = 0;
        try {
            if (incParam.get("value") != null) value = Integer.parseInt(incParam.get("value")[0]);
            if ((value > 100) || (value < 0)) result.add("Invalid \"value\"");
        } catch (Exception e) {
            result.add("Invalid \"value\"");
        }
        try {
            if (incParam.get("studentId") != null) Integer.parseInt(incParam.get("studentId")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of student");
        }
        try {
            if (incParam.get("lessonId") != null) Integer.parseInt(incParam.get("lessonId")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of lesson");
        }
        try {
            if (incParam.get("id") != null) Integer.parseInt(incParam.get("id")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of mark");
        }
        return result;
    }

    public List<DBObject> getObjects(Map<String, String[]> incParam, String stopWord) {
        if ((incParam == null) || incParam.isEmpty() || (stopWord == null) || !incParam.containsKey(stopWord))
            return new ArrayList<>();
        return objectsDAO.getAllByParam(incParam, stopWord);
    }

    public void addObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return;
        objectsDAO.addObject(incParam);
    }

    public void delObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return;
        objectsDAO.deleteObjectById(Integer.parseInt(incParam.get("id")[0]));
    }

    public void updateObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return;
        objectsDAO.updateObject(incParam);
    }
}
