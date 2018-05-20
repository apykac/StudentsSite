package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.DBObject;

import java.util.List;
import java.util.Map;

public interface ObjectsDAO {
    boolean addObject(Map<String, String[]> incParam);

    DBObject getObjectById(int id);

    boolean updateObject(Map<String, String[]> incParam);

    boolean deleteObjectById(int id);

    List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord);
}
