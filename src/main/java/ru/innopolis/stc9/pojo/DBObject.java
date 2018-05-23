package ru.innopolis.stc9.pojo;

import ru.innopolis.stc9.db.dao.TypeOfGetSet;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Интерфейс сущности Объект базы данных
 */
public interface DBObject {
    /**
     * возращает карту параметрров [название_столбца] -> [тип_данных]
     * @return HashMap
     */
    Map<String, TypeOfGetSet> getParamMap();

    /**
     * Возвращает список объектов пар {[имя_метода],[тип_возвращаемого_значения]}
     * @param isOrdered порядок построения списка
     * @return ArrayList
     */
    List<Object[]> getDBOMethods(boolean isOrdered);

    /**
     * Возвращает объект БД по входящим данных ResultSet
     * @param resultSet объект ResultSet
     * @return DBObject
     */
    DBObject getByResultSet (ResultSet resultSet);

    /**
     * Возвращает объект БД по карте параметров со траницы с формой
     * @param incParam карта параметров [название_поля] -> [значение_поля]
     * @return DBObject
     */
    DBObject getByParam (Map<String, String[]> incParam);
}
