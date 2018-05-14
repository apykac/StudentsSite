package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsDAOImpl implements SubjectsDAO {
    private static Logger logger = Logger.getLogger(SubjectsDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addSubject(Subject subject) {
        logger.info("Start adding an \"subject\": {" + subject.getName() + "/" + subject.getCourseId() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO subjects VALUES (DEFAULT, ?, ?)");
            statement.setString(1, subject.getName());
            statement.setInt(2, subject.getCourseId());
            statement.addBatch();
            logger.info("Adding a \"subject\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"subject\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Subject getSubjectById(int id) {
        logger.info("Start getting an \"subject\" by id=" + id);
        Subject subject = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subject = new Subject(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("course")
                );
            }
        } catch (SQLException e) {
            logger.error("Getting a \"subject\" failed: " + e.getMessage(), e);
            return null;
        }
        if (subject != null)
            logger.info("Getting a \"subject\" successfully, \"subject\": {" + subject.getName() + "/" + subject.getCourseId() + "}");
        else
            logger.info("Getting a \"subject\" successfully, \"subject\": NULL");
        return subject;
    }

    @Override
    public boolean updateSubject(Subject subject) {
        logger.info("Start updating an \"subject\": {" + subject.getName() + "/" + subject.getCourse().getName() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE subjects SET " +
                    "name = ?, " +
                    "course = ? " +
                    "WHERE id = ?");
            statement.setString(1, subject.getName());
            statement.setInt(2, subject.getCourseId());
            statement.setInt(3, subject.getId());
            statement.addBatch();
            logger.info("Updating a \"subject\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"subject\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteSubjectById(int id) {
        logger.info("Start deleting an \"subject\" by id=" + id);
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
}
