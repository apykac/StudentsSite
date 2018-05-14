package ru.innopolis.stc9.db.dao;


import ru.innopolis.stc9.pojo.Mark;

public interface MarksDAO {
    boolean addMark(Mark mark);

    Mark getMarkById(int id);

    boolean updateMark(Mark mark);

    boolean deleteMarkById(int id);
}
