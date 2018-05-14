package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.Lesson;

public interface LessonsDAO {
    boolean addLesson(Lesson lesson);

    Lesson getLessonById(int id);

    boolean updateLesson(Lesson lesson);

    boolean deleteLessonById(int id);
}
