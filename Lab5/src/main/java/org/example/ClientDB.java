package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDB {
    private static Connection connection;

    public ClientDB(DataBaseManager manager) {
        connection = manager.getConnection();
    }

    public void createClientTable() {
        String query = "CREATE TABLE IF NOT EXISTS Client (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR(50) NOT NULL, " +
                "lastName VARCHAR(50) NOT NULL, " +
                "patronymic VARCHAR(50) NOT NULL, " +
                "dateOfBirth Date NOT NULL, " +
                "passportId VARCHAR(30) NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropClientTable() {
        String query = "DROP TABLE IF EXISTS Client";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


