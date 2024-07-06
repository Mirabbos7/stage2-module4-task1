package com.mjc.stage2;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection getConnection() throws SQLException;

    Connection createConnection() throws SQLException;
}
