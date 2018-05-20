package ru.innopolis.stc9.services;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.dao.CoursesDAO;
import ru.innopolis.stc9.db.dao.ObjectsDAO;
import ru.innopolis.stc9.pojo.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {
    private static Logger logger = Logger.getLogger(CourseService.class);
    private static ObjectsDAO coursesDAO = new CoursesDAO();

    public static List<String> isCorrectData(Map<String, String[]> incParam) {
        List<String> result = new ArrayList<>();
        if ((incParam.get("name") != null) && incParam.get("name")[0].equals("")) result.add("Invalid name of course");
        try {
            if (incParam.get("id") != null)
                Integer.parseInt(incParam.get("id")[0]);
        } catch (Exception e) {
            result.add("Invalid ID of course");
        }
        return result;
    }

    public List<DBObject> getCourses(Map<String, String[]> incParam, String stopWord) {
        return coursesDAO.getAllByParam(incParam, stopWord);
    }

    public void addCourse(Map<String, String[]> incParam) {
        coursesDAO.addObject(incParam);
    }

    public void delCourse(Map<String, String[]> incParam) {
        coursesDAO.deleteObjectById(Integer.parseInt(incParam.get("id")[0]));
    }

    public void updateCourse(Map<String, String[]> incParam) {
        coursesDAO.updateObject(incParam);
    }
}
