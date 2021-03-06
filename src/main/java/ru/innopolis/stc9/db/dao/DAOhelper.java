package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.pojo.DBObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DAOhelper {
    private static Logger logger = Logger.getLogger(DAOhelper.class);

    public DAOhelper() {
    }

    public DBObject getByParam(Map<String, String[]> incParam, DBObject object) {
        if ((incParam == null) || incParam.isEmpty() || object == null) return null;
        return object.getByParam(incParam);
    }

    public DBObject getByResultSet(ResultSet resultSet, DBObject object) {
        if ((resultSet == null) || (object == null)) return null;
        return object.getByResultSet(resultSet);
    }

    public void statementSetter(PreparedStatement statement, DBObject object, int length, boolean isOrdred) {
        if ((statement == null) || (object == null) || (length < 0)) return;
        int count = 1;
        for (Object[] pair : object.getDBOMethods(false)) {
            if (length == 0) break;
            try {
                Method method = object.getClass().getMethod((String) pair[0]);
                setting(statement, count, (TypeOfGetSet) pair[1], method.invoke(object), false);
                length--;
                count++;
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void simpleStatementSetter(PreparedStatement statement, DBObject object, Map<String, String[]> incParam,
                                      String stopWord, boolean isPattern) {
        if ((statement == null) || (object == null) || (incParam == null) || incParam.isEmpty() || (stopWord == null) || incParam.isEmpty())
            return;
        Map<String, TypeOfGetSet> typeOfGetSetMap = object.getParamMap();
        int count = 1;
        for (Map.Entry<String, String[]> pair : incParam.entrySet()) {
            if (pair.getKey().equals(stopWord)) break;
            setting(statement, count, typeOfGetSetMap.get(pair.getKey()), pair.getValue()[0], isPattern);
            count++;
        }
    }

    public void setting(PreparedStatement statement, int count, TypeOfGetSet type, Object o, boolean isPattern) {
        if ((statement == null) || (count < 0) || (o == null)) return;
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
