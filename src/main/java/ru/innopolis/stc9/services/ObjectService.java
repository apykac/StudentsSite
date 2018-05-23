package ru.innopolis.stc9.services;

import ru.innopolis.stc9.pojo.DBObject;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс Сервис объекта БД
 */
public interface ObjectService {
    /**
     * Проверяет корректность ввода данных, и возвращает список ошибок, либок пустой список если ошибок нет
     * @param incParam карта параметров ввода с формы запроса на странице
     * @return ArrayList
     */
    List<String> isCorrectData(Map<String, String[]> incParam);

    /**
     * Возвращает список объектов со слоя ДАО по карте параметров
     * @param incParam карта параметров ввода с формы запроса на странице
     * @param stopWord стоп слово для того чтобы не задеть лишние данные при оброботке
     * @return ArrayList
     */
    List<DBObject> getObjects(Map<String, String[]> incParam, String stopWord);

    /**
     * Добавление объекта через слои ДАО используя карту параметров
     * @param incParam карта параметров ввода с формы запроса на странице
     */
    void addObject(Map<String, String[]> incParam);

    /**
     * Удаление объекта через слои ДАО используя карту параметров
     * @param incParam карта параметров ввода с формы запроса на странице
     */
    void delObject(Map<String, String[]> incParam);

    /**
     * Обновление объекта через слои ДАО используя карту параметров
     * @param incParam карта параметров ввода с формы запроса на странице
     */
    void updateObject(Map<String, String[]> incParam);
}
