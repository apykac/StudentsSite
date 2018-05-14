package ru.innopolis.stc9.db.connection_manager;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToStudentsDB implements ConnectionManager {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentsDB";
    private static final String USER = "postgres";
    private static final String PSSWRD = "qwerty=)";
    private static Logger logger = Logger.getLogger(ConnectionToStudentsDB.class);
    private static ConnectionManager connectionManager;

    public static ConnectionManager getInstance() {
        if (connectionManager == null) connectionManager = new ConnectionToStudentsDB();
        return connectionManager;
    }

    private ConnectionToStudentsDB() {
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PSSWRD);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}