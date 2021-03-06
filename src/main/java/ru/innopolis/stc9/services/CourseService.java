package ru.innopolis.stc9.services;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.dao.CoursesDAO;
import ru.innopolis.stc9.db.dao.ObjectsDAO;
import ru.innopolis.stc9.pojo.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Сервис курсов
 */
public class CourseService implements ObjectService {
    private static Logger logger = Logger.getLogger(CourseService.class);
    private static ObjectsDAO objectsDAO = new CoursesDAO();

    public List<String> isCorrectData(Map<String, String[]> incParam) {
        List<String> result = new ArrayList<>();
        if (incParam == null || incParam.isEmpty()) return result;
        if ((incParam.get("name") != null) && incParam.get("name")[0].equals("")) result.add("Invalid name of course");
        try {
            if (incParam.get("id") != null)
                Integer.parseInt(incParam.get("id")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of course");
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
