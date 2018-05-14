package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonsDAOImpl implements LessonsDAO {
    private static Logger logger = Logger.getLogger(LessonsDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addLesson(Lesson lesson) {
        logger.info("Start adding an \"lesson\": {" + lesson.getSubjectId() + "/"
                + lesson.getBegin() + " - " + lesson.getEnd() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO lessons VALUES (DEFAULT, ?, ?, ?)");
            statement.setInt(1, lesson.getSubjectId());
            statement.setDate(2, lesson.getBegin());
            statement.setDate(3, lesson.getEnd());
            statement.addBatch();
            logger.info("Adding a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Lesson getLessonById(int id) {
        logger.info("Start getting an \"lesson\" by id=" + id);
        Lesson lesson = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = new Lesson(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject"),
                        resultSet.getDate("beginOfLesson"),
                        resultSet.getDate("endOfLesson")
                );
            }
        } catch (SQLException e) {
            logger.error("Getting a \"lesson\" failed: " + e.getMessage(), e);
            return null;
        }
        if (lesson != null)
            logger.info("Getting a \"lesson\" successfully, \"lesson\": {" + lesson.getSubjectId() + "/"
                    + lesson.getBegin() + " - " + lesson.getEnd() + "}");
        else
            logger.info("Getting a \"lesson\" successfully, \"lesson\": NULL");
        return lesson;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        logger.info("Start updating an \"lesson\": {" + lesson.getSubject().getName() + "/"
                + lesson.getBegin() + " - " + lesson.getEnd() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE lessons SET " +
                    "subject = ?, " +
                    "begin = ?, " +
                    "\"end\" = ?" +
                    "WHERE id = ?");
            statement.setInt(1, lesson.getSubjectId());
            statement.setDate(2, lesson.getBegin());
            statement.setDate(3, lesson.getEnd());
            statement.setInt(4, lesson.getId());
            statement.addBatch();
            logger.info("Updating a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteLessonById(int id) {
        logger.info("Start deleting an \"lesson\" by id=" + id);
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM timetableOfClasses WHERE id = ?");
            statement.setInt(1, id);
            statement.addBatch();
            logger.info("Deleting a \"lesson\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Deleting a \"lesson\" failed: " + e.getMessage(), e);
            return false;
        }
    }
}
