package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.Subject;

public interface SubjectsDAO {
    boolean addSubject(Subject subject);

    Subject getSubjectById(int id);

    boolean updateSubject(Subject subject);

    boolean deleteSubjectById(int id);
}
