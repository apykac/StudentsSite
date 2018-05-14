package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesDAOImpl implements CoursesDAO {
    private static Logger logger = Logger.getLogger(CoursesDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addCourse(Course course) {
        logger.info("Start adding an \"course\": {" + course.getName() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO courses VALUES (DEFAULT, ?)");
            statement.setString(1, course.getName());
            statement.addBatch();
            logger.info("Adding a \"course\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"course\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Course getCourseById(int id) {
        logger.info("Start getting an \"course\" by id=" + id);
        Course course = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                course = new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            logger.error("Getting a \"course\" failed: " + e.getMessage(), e);
            return null;
        }
        if (course != null)
            logger.info("Getting a \"course\" successfully, \"course\": {" + course.getName() + "}");
        else
            logger.info("Getting a \"course\" successfully, \"course\": NULL");
        return course;
    }

    @Override
    public boolean updateCourse(Course course) {
        logger.info("Start updating an \"course\": {" + course.getName() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE courses SET " +
                    "name = ?" +
                    "WHERE id = ?");
            statement.setInt(1, course.getId());
            statement.setString(2, course.getName());
            statement.addBatch();
            logger.info("Updating a \"course\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"course\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteCourseById(int id) {
        logger.info("Start deleting an \"course\" by id=" + id);
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
}
