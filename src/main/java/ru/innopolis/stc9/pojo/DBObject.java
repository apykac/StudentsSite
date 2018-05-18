package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.util.Map;

public abstract class DBObject {
    public abstract Map<String, TypeOfGetSet> getParamMap();
    public abstract Map<String, TypeOfGetSet> getDBOMethods();
}
