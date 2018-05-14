package ru.innopolis.stc9.db.connection_manager;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
