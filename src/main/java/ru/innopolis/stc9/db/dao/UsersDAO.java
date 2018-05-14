package ru.innopolis.stc9.db.dao;

import ru.innopolis.stc9.pojo.User;

import java.sql.SQLException;

public interface UsersDAO {
    User getUserByLogin(String login) throws SQLException;
}
