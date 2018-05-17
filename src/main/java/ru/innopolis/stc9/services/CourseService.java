package ru.innopolis.stc9.services;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.dao.CoursesDAO;
import ru.innopolis.stc9.db.dao.CoursesDAOImpl;
import ru.innopolis.stc9.pojo.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static Logger logger = Logger.getLogger(CourseService.class);
    private static CoursesDAO coursesDAO = new CoursesDAOImpl();

    public List<Object> getCourses(String courseName) {
        List<Object> result = new ArrayList<>();
        List<Course> courses = getCoursesByName(courseName);
        for (Course course : courses) {
            result.add(course);
        }
        return result;
    }

    public List<Course> getCoursesByName(String courseName) {
        courseName = courseName.equals("") ? null : courseName;
        return coursesDAO.getAllCoursesByName(courseName);
    }

    public void addCourse(String courseName) {
        coursesDAO.addCourse(new Course(0, courseName));
    }

    public void delCourse(Integer courseId) {
        coursesDAO.deleteCourseById(courseId);
    }
}
