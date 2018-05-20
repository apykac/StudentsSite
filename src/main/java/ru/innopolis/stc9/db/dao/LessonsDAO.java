package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LessonsDAO implements ObjectsDAO {
    private DAOhelper helper = new DAOhelper();
    private static Logger logger = Logger.getLogger(LessonsDAO.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addObject(Map<String, String[]> incParam) {
        logger.info("Start adding an \"lesson\"");
        DBObject lesson = helper.getByParam(incParam,new Lesson());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO lessons VALUES (DEFAULT, ?, ?, ?)");
            helper.statementSetter(statement, lesson, 3, false);
            statement.addBatch();
            logger.info("Adding a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Lesson getObjectById(int id) {
        logger.info("Start getting an \"lesson\" by id");
        Lesson lesson = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) lesson = (Lesson) helper.getByResultSet(resultSet, new Lesson());
        } catch (SQLException e) {
            logger.error("Getting a \"lesson\" failed: " + e.getMessage(), e);
            return null;
        }
        logger.info("Getting a \"lesson\" successfully, \"lesson\"");
        return lesson;
    }

    @Override
    public boolean updateObject(Map<String, String[]> incParam) {
        logger.info("Start updating an \"lesson\"");
        DBObject lesson = helper.getByParam(incParam,new Lesson());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE lessons SET " +
                    "subject = ?, " +
                    "begin = ?, " +
                    "\"end\" = ?" +
                    "WHERE id = ?");
            helper.statementSetter(statement,lesson,4,false);
            statement.addBatch();
            logger.info("Updating a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteObjectById(int id) {
        logger.info("Start deleting an \"lesson\" by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM lessons WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<DBObject> result = new ArrayList<>();
        logger.info("Getting an \"students\" by name");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) result.add(helper.getByResultSet(resultSet, new Lesson()));
        } catch (SQLException e) {
            logger.info("Getting an \"students\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"students\" by name successfully");
        return result;
    }
}
