package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAOImpl implements UsersDAO {
    private static Logger logger = Logger.getLogger(UsersDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        logger.info("Start to find users");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "* FROM users " +
                    "WHERE login=?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("login"),
                        resultSet.getString("passwordHash"), resultSet.getInt("role"));
            }
        } catch (SQLException e) {
            logger.error("Finding a \"user\" failed: " + e.getMessage(), e);
        }
        if (user != null)
            logger.info("Finding a \"user\" successfully, \"user\": " + user.getLogin());
        else
            logger.info("Finding a \"user\" successfully, \"user\": NULL");
        return user;
    }
}
