package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.pojo.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ДАО предметов
 */
public class SubjectsDAO implements ObjectsDAO {
    private DAOhelper helper = new DAOhelper();
    private static Logger logger = Logger.getLogger(SubjectsDAO.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return false;
        DBObject subject = helper.getByParam(incParam, new Subject());
        logger.info("Start adding an \"subject\"");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO subjects VALUES (DEFAULT, ?, ?)");
            helper.statementSetter(statement, subject, 2, false);
            statement.addBatch();
            logger.info("Adding a \"subject\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"subject\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Subject getObjectById(int id) {
        logger.info("Start getting an \"subject\" by id");
        Subject subject = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) subject = (Subject) helper.getByResultSet(resultSet, new Subject());
        } catch (SQLException e) {
            logger.error("Getting a \"subject\" failed: " + e.getMessage(), e);
            return null;
        }
        logger.info("Getting a \"subject\" successfully, \"subject\"");
        return subject;
    }

    @Override
    public boolean updateObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return false;
        logger.info("Start updating an \"subject\"");
        DBObject subject = helper.getByParam(incParam, new Subject());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE subjects SET " +
                    "name = ?, " +
                    "course = ? " +
                    "WHERE id = ?");
            helper.statementSetter(statement, subject, 3, false);
            statement.addBatch();
            logger.info("Updating a \"subject\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"subject\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteObjectById(int id) {
        logger.info("Start deleting an \"subject\" by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM subjects WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"subject\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"subject\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<DBObject> result = new ArrayList<>();
        if ((incParam == null) || incParam.isEmpty() || (stopWord == null) || !incParam.containsKey(stopWord))
            return result;
        logger.info("Getting an \"subject\" by name");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects WHERE \"name\" LIKE ?");
            helper.simpleStatementSetter(statement, new Subject(), incParam, stopWord, true);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) result.add(helper.getByResultSet(resultSet, new Subject()));
        } catch (SQLException e) {
            logger.info("Getting an \"subject\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"subject\" by name successfully");
        return result;
    }
}
