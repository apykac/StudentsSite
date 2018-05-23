package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.DBObject;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс - объект БД с методами
 */
public interface ObjectsDAO {
    /**
     * Добавление объекта в БД
     * @param incParam список параметров полученный при пзаполнениеи формы на странице
     * @return возвращает true/false в зависимости от успешности метода
     */
    boolean addObject(Map<String, String[]> incParam);

    /**
     * Получения объекта из базы данных
     * @param id ID объекта по которому идет поиск по БД
     * @return
     */
    DBObject getObjectById(int id);

    /**
     * Обновление ланных обьъекта
     * @param incParam список параметров изменения полученных после заполнения формы на сайте
     * @return возвращает true/false в зависимости от успешности метода
     */
    boolean updateObject(Map<String, String[]> incParam);

    /**
     * Удаление объекта из БД
     * @param id ID объекта по которому ведеться поиск
     * @return возвращает true/false в зависимости от успешности метода
     */
    boolean deleteObjectById(int id);

    /**
     * Полчучения списка объектов из БД
     * @param incParam Список параметров полученным после заполнения формы на сайте, по которымм ведется поиск
     * @param stopWord Слово-остановка используется для прохождения по списку параметров чтобы не зацепить лишние данные
     * @return возвращает список объектов в основном ввиде ArrayList
     */
    List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord);
}
