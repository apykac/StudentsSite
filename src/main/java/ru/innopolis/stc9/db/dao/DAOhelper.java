package ru.innopolis.stc9.db.dao;

import com.sun.javafx.collections.MappingChange;
import org.apache.log4j.Logger;
import ru.innopolis.stc9.pojo.DBObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DAOhelper {
    private DBObject object;
    private static Logger logger = Logger.getLogger(DAOhelper.class);

    public DAOhelper(DBObject object) {
        this.object = object;
    }

    public void statmentSetter(PreparedStatement statement, Map<String, String[]> incParam,
                               String stopWord, boolean isPattern, int length) {
        if (length == 0) {
            simpleStatementSetter(statement, incParam, stopWord, object.getParamMap(), isPattern);
            return;
        }
        int count = 1;
        for (Map.Entry<String, TypeOfGetSet> pair : object.getDBOMethods().entrySet()) {
            if (length == 0) break;
            try {
                Method method = object.getClass().getMethod(pair.getKey());
                Object o = null;
                method.invoke(o);
                setting(statement, count, pair.getValue(), o, false);
                length--;
                count--;
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void simpleStatementSetter(PreparedStatement statement, Map<String, String[]> incParam, String stopWord,
                                      Map<String, TypeOfGetSet> typeOfGetSetMap, boolean isPattern) {
        int count = 1;
        for (Map.Entry<String, String[]> pair : incParam.entrySet()) {
            if (pair.getKey().equals(stopWord)) break;
            setting(statement, count, typeOfGetSetMap.get(pair.getKey()), pair.getValue()[0], isPattern);
            count++;
        }
    }

    public void setting(PreparedStatement statement, int count, TypeOfGetSet type, Object o, boolean isPattern) {
        try {
            switch (type) {
                case DATE:
                    statement.setDate(count, (Date) o);
                    return;
                case STRING:
                    statement.setString(count, isPattern ? "%" + o + "%" : (String) o);
                    return;
                case INTEGER:
                    statement.setInt(count, (Integer) o);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
