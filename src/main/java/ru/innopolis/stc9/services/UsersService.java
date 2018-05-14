package ru.innopolis.stc9.services;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.dao.UsersDAO;
import ru.innopolis.stc9.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.pojo.User;

import java.sql.SQLException;

public class UsersService {
    private static Logger logger = Logger.getLogger(UsersService.class);
    private static UsersDAO usersDao = new UsersDAOImpl();

    public int checkAuth(String login, String password) {
        User user = null;
        try {
            user = usersDao.getUserByLogin(login);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if ((user != null) && (user.getPasswordHash().equals(password)))
            return user.getRole();
        else return 0;
    }
}
