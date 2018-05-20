package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.pojo.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarksDAO implements ObjectsDAO {
    private DAOhelper helper = new DAOhelper();
    private static Logger logger = Logger.getLogger(MarksDAO.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addObject(Map<String, String[]> incParam) {
        logger.info("Start adding an \"mark\"");
        DBObject mark = helper.getByParam(incParam, new Mark());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO marks VALUES (DEFAULT, ?, ?, ?)");
            helper.statementSetter(statement, mark, 3, false);
            statement.addBatch();
            logger.info("Adding a \"mark\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"mark\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public DBObject getObjectById(int id) {
        Mark mark = null;
        logger.info("Start getting an \"mark\" by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM marks WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) mark = (Mark) helper.getByResultSet(resultSet, new Mark());
        } catch (SQLException e) {
            logger.error("Getting a \"mark\" failed: " + e.getMessage(), e);
            return null;
        }
        logger.info("Getting a \"mark\" successfully, \"mark\": NULL");
        return mark;
    }

    @Override
    public boolean updateObject(Map<String, String[]> incParam) {
        logger.info("Start updating an \"mark\"");
        DBObject mark = helper.getByParam(incParam,new Mark());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE marks SET " +
                    "student = ?, " +
                    "lesson = ?, " +
                    "value = ?" +
                    "WHERE id = ?");
            helper.statementSetter(statement,mark,4,false);
            statement.addBatch();
            logger.info("Updating a \"mark\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"mark\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteObjectById(int id) {
        logger.info("Start deleting an \"mark\" by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM marks WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"mark\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"mark\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<DBObject> result = new ArrayList<>();
        logger.info("Getting an \"students\" by name");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM marks");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) result.add(helper.getByResultSet(resultSet, new Mark()));
        } catch (SQLException e) {
            logger.info("Getting an \"students\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"students\" by name successfully");
        return result;
    }
}
