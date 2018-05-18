package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksDAOImpl implements MarksDAO {
    private static Logger logger = Logger.getLogger(MarksDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addMark(Mark mark) {
        logger.info("Start adding an \"mark\": {" + mark.getStudentId() + "/" + mark.getLessonId() + "/" + mark.getValue() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO marks VALUES (DEFAULT, ?, ?, ?)");
            statement.setInt(1, mark.getStudentId());
            statement.setInt(2, mark.getLessonId());
            statement.setInt(3, mark.getValue());
            statement.addBatch();
            logger.info("Adding a \"mark\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"mark\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Mark getMarkById(int id) {
        Mark mark = null;
        logger.info("Start getting an \"mark\" by id=" + id);
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM marks WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                mark = new Mark(
                        resultSet.getInt("id"),
                        resultSet.getInt("student"),
                        resultSet.getInt("lesson"),
                        resultSet.getInt("value")
                );
            }
        } catch (SQLException e) {
            logger.error("Getting a \"mark\" failed: " + e.getMessage(), e);
            return null;
        }
        if (mark != null)
            logger.info("Getting a \"mark\" successfully, \"mark\": {" + mark.getStudentId() + "/" + mark.getLessonId() + "/" + mark.getValue() + "}");
        else
            logger.info("Getting a \"mark\" successfully, \"mark\": NULL");
        return mark;
    }

    @Override
    public boolean updateMark(Mark mark) {
        logger.info("Start updating an \"mark\": {" + mark.getStudentId() + "/" + mark.getLessonId() + "/" + mark.getValue() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE marks SET " +
                    "student = ?, " +
                    "lesson = ?, " +
                    "value = ?" +
                    "WHERE id = ?");
            statement.setInt(1, mark.getStudentId());
            statement.setInt(2, mark.getLessonId());
            statement.setInt(3, mark.getValue());
            statement.setInt(4, mark.getId());
            statement.addBatch();
            logger.info("Updating a \"mark\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"mark\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteMarkById(int id) {
        logger.info("Start deleting an \"mark\" by id=" + id);
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
}
