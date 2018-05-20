package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface DBObject {
    Map<String, TypeOfGetSet> getParamMap();
    List<Object[]> getDBOMethods(boolean isOrdered);
    DBObject getByResultSet (ResultSet resultSet);
    DBObject getByParam (Map<String, String[]> incParam);
}
