package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.User;

import java.sql.SQLException;

/**
 * Интерфейс DAO пользователя
 */
public interface UsersDAO {
    /**
     * получить пользователья по логину
     * @param login логин пользователя
     * @return возращает пользователя
     * @throws SQLException
     */
    User getUserByLogin(String login) throws SQLException;
}
