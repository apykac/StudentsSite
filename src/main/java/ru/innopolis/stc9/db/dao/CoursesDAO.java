package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.Course;

public interface CoursesDAO {
    boolean addCourse(Course course);

    Course getCourseById(int id);

    boolean updateCourse(Course course);

    boolean deleteCourseById(int id);
}

