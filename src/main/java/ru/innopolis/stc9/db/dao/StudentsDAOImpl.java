package ru.innopolis.stc9.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.db.connection_manager.ConnectionManager;
import ru.innopolis.stc9.db.connection_manager.ConnectionToStudentsDB;
import ru.innopolis.stc9.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentsDAOImpl implements StudentsDAO {
    private DAOhelper helper = new DAOhelper(new Student());
    private static Logger logger = Logger.getLogger(StudentsDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionToStudentsDB.getInstance();

    @Override
    public boolean addStudent(Student student) {
        logger.info("Start adding an \"student\": {" + student.getSecondName() + "/" + student.getFirstName() + "/"
                + student.getMiddleName() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students VALUES (DEFAULT, ?, ?, ?, ?)");
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, student.getCourseId());
            statement.addBatch();
            logger.info("Adding a \"student\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Adding a \"student\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Student getStudentById(int id) {
        logger.info("Start getting an \"student\" by id=" + id);
        Student student = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) student = new Student(resultSet);
        } catch (SQLException e) {
            logger.error("Getting a \"student\" failed: " + e.getMessage(), e);
            return null;
        }
        if (student != null)
            logger.info("Getting a \"student\" successfully, \"student\": {" + student.getSecondName() + "/"
                    + student.getFirstName() + "/" + student.getMiddleName() + "}");
        else
            logger.info("Getting a \"student\" successfully, \"student\": NULL");
        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        logger.info("Updating adding an \"student\": {" + student.getSecondName() + "/" + student.getFirstName() + "/"
                + student.getMiddleName() + "}");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE students SET " +
                    "\"firstName\" = ?, " +
                    "\"secondName\" = ?, " +
                    "\"middleName\" = ?, " +
                    "course = ?" +
                    "WHERE id = ?");

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setString(3, student.getMiddleName());
            statement.setInt(4, student.getCourseId());
            statement.setInt(5, student.getId());
            statement.addBatch();
            logger.info("Updating a \"student\" successfully");
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Updating a \"student\" failed: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(int id) {
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

    public List<Student> getAllByParam(Map<String, String[]> incParam, String stopWord) {
        List<Student> result = new ArrayList<>();
        logger.info("Getting an \"students\" by name");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE " +
                    "\"firstName\" LIKE ? AND " +
                    "\"secondName\" LIKE ? AND " +
                    "\"middleName\" LIKE ?");
            helper.statmentSetter(statement,incParam,stopWord,true,0);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Student(resultSet));
            }
        } catch (SQLException e) {
            logger.info("Getting an \"students\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"students\" by name successfully");
        return result;
    }

}
