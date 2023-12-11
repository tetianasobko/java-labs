package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager {
    private final String url;
    private Connection connection;

    public DataBaseManager(String url) {
        this.url = url;

        init();
    }

    public Connection getConnection() {
        return connection;
    }

    public void init() {
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Database is connected!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
