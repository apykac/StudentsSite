package ru.innopolis.stc9.services;

import ru.innopolis.stc9.pojo.DBObject;

import java.util.List;
import java.util.Map;

public interface ObjectService {
    List<String> isCorrectData(Map<String, String[]> incParam);
    List<DBObject> getObjects(Map<String, String[]> incParam, String stopWord);
    void addObject(Map<String, String[]> incParam);
    void delObject(Map<String, String[]> incParam);
    void updateObject(Map<String, String[]> incParam);
}
