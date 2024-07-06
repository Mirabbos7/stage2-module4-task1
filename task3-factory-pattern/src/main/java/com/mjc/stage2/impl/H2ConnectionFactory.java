package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    private String jdbcDriver;
    private String dbUrl;
    private String user;
    private String password;

    public H2ConnectionFactory() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("h2database.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find h2database.properties");
                return;
            }

            Properties prop = new Properties();
            prop.load(input);

            jdbcDriver = prop.getProperty("jdbc_driver");
            dbUrl = prop.getProperty("db_url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            Class.forName(jdbcDriver);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password);
    }

    @Override
    public Connection createConnection() throws SQLException {
        return null;
    }
}

