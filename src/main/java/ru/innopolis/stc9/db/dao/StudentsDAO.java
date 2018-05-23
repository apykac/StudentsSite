package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.DBObject;
import ru.innopolis.stc9.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ДАО студентов
 */
public class StudentsDAO implements ObjectsDAO {
    private DAOhelper helper = new DAOhelper();
    private static Logger logger = Logger.getLogger(StudentsDAO.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return false;
        logger.info("Start adding an \"student\"");
        DBObject student = helper.getByParam(incParam, new Student());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students VALUES (DEFAULT, ?, ?, ?, ?)");
            helper.statementSetter(statement, student, 4, false);
            statement.addBatch();
            logger.info("Adding a \"student\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"student\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Student getObjectById(int id) {
        logger.info("Start getting an \"student\" by id=" + id);
        Student student = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) student = (Student) helper.getByResultSet(resultSet, new Student());
        } catch (SQLException e) {
            logger.error("Getting a \"student\" failed: " + e.getMessage(), e);
            return null;
        }
        logger.info("Getting a \"student\" successfully");
        return student;
    }

    @Override
    public boolean updateObject(Map<String, String[]> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return false;
        logger.info("Updating adding an \"student\"");
        DBObject student = helper.getByParam(incParam, new Student());
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE students SET " +
                    "\"firstName\" = ?, " +
                    "\"secondName\" = ?, " +
                    "\"middleName\" = ?, " +
                    "course = ? " +
                    "WHERE id = ?");
            helper.statementSetter(statement,student,5,false);
            statement.addBatch();
            logger.info("Updating a \"student\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"student\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteObjectById(int id) {
        logger.info("Deleting an \"student\" by id=" + id);
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"student\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"student\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<DBObject> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<DBObject> result = new ArrayList<>();
        if ((incParam == null) || incParam.isEmpty() || (stopWord == null) || !incParam.containsKey(stopWord))
            return result;
        logger.info("Getting an \"students\" by name");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE " +
                    "\"firstName\" LIKE ? AND " +
                    "\"secondName\" LIKE ? AND " +
                    "\"middleName\" LIKE ?");
            helper.simpleStatementSetter(statement, new Student(), incParam, stopWord, true);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) result.add(helper.getByResultSet(resultSet, new Student()));
        } catch (SQLException e) {
            logger.info("Getting an \"students\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"students\" by name successfully");
        return result;
    }

}
