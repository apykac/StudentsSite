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

public class StudentsDAOImpl implements StudentsDAO {
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
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("middleName"),
                        resultSet.getInt("course")
                );
            }
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

    @Override
    public List<Student> getAllStudentsByName(String firstName, String secondName, String middleName) {
        List<Student> result = new ArrayList<>();
        logger.info("Getting an \"students\" by name: " + secondName + " " + firstName + " " + middleName);
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = rightStatment(firstName, secondName, middleName, connection);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("middleName"),
                        resultSet.getInt("course")
                );
                result.add(student);
            }
        } catch (SQLException e) {
            logger.info("Getting an \"students\" by name failed: " + e.getMessage(), e);
            return result;
        }
        logger.info("Get all \"students\" by name successfully");
        return result;
    }

    private PreparedStatement rightStatment(String firstName, String secondName, String middleName, Connection connection) throws SQLException {
        PreparedStatement statement;
        String prefix = "SELECT * FROM students WHERE ";
        if (firstName == null && secondName == null && middleName == null) {
            statement = connection.prepareStatement("SELECT * FROM students");
            return statement;
        }
        if (firstName == null && secondName == null) {
            statement = connection.prepareStatement(prefix + "\"middleName\"=?");
            statement.setString(1, middleName);
            return statement;
        }
        if (middleName == null && secondName == null) {
            statement = connection.prepareStatement(prefix + "\"firstName\"=?");
            statement.setString(1, firstName);
            return statement;
        }
        if (middleName == null && firstName == null) {
            statement = connection.prepareStatement(prefix + "\"secondName\"=?");
            statement.setString(1, secondName);
            return statement;
        }
        if (middleName == null) {
            statement = connection.prepareStatement(prefix + "\"firstName\"=? AND \"secondName\"=?");
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            return statement;
        }
        if (firstName == null) {
            statement = connection.prepareStatement(prefix + "\"middleName\"=? AND \"secondName\"=?");
            statement.setString(1, middleName);
            statement.setString(2, secondName);
            return statement;
        }
        if (secondName == null) {
            statement = connection.prepareStatement(prefix + "\"firstName\"=? AND \"middleName\"=?");
            statement.setString(1, firstName);
            statement.setString(2, middleName);
            return statement;
        }
        statement = connection.prepareStatement(prefix + "\"firstName\"=? AND \"secondName\"=? AND \"middleName\"=?");
        statement.setString(1, firstName);
        statement.setString(2, secondName);
        statement.setString(3, middleName);
        return statement;
    }
}
