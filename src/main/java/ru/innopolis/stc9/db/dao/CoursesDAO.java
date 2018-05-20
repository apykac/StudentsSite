package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Course;
import ru.innopolis.stc9.pojo.DBObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursesDAO implements ObjectsDAO {
    private DAOhelper helper = new DAOhelper();
    private static Logger logger = Logger.getLogger(CoursesDAO.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addObject(Map<String, String[]> incParam) {
        DBObject course = helper.getByParam(incParam, new Course());
        logger.info("Start adding an \"course\"");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO courses VALUES (DEFAULT, ?)");
            helper.statementSetter(statement, course, 4, false);
            statement.addBatch();
            logger.info("Adding a \"course\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"course\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Course getObjectById(int id) {
        logger.info("Start getting an \"course\" by id");
        Course course = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) course = (Course) helper.getByResultSet(resultSet, new Course());
        } catch (SQLException e) {
            logger.error("Getting a \"course\" failed: " + e.getMessage(), e);
            return null;
        }
        logger.info("Getting a \"course\" successfully, \"course\"");
        return course;
    }

    @Override
    public boolean updateObject(Map<String, String[]> incParam) {
        logger.info("Start updating an \"course\"");
        DBObject course = helper.getByParam(incParam, new Course());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE courses SET name = ? WHERE id = ?");
            /*statement.setInt(1, course.getId());
            statement.setString(2, course.getName());*/
            helper.statementSetter(statement, course, 2, false);
            statement.addBatch();
            logger.info("Updating a \"course\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"course\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteObjectById(int id) {
        logger.info("Start deleting an \"course\" by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM courses WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"course\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"course\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<DBObject> result = new ArrayList<>();
        logger.info("Getting an \"courses\"");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE name LIKE ?");
            helper.simpleStatementSetter(statement, new Course(), incParam, stopWord, true);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                result.add(helper.getByResultSet(resultSet, new Course()));
        } catch (SQLException e) {
            logger.info("Getting an \"courses\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"courses\" by name successfully");
        return result;
    }
}
