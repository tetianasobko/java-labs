package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountDB {
    private static Connection connection;

    public BankAccountDB(DataBaseManager manager) {
        connection = manager.getConnection();
    }

    public void createBankAccountTable() {
        String query = "CREATE TABLE IF NOT EXISTS BankAccount (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accountType VARCHAR(9) NOT NULL, " +
                "accountNumber VARCHAR(11) NOT NULL, " +
                "currencyType VARCHAR(3) NOT NULL, " +
                "balance MONEY NOT NULL, " +
                "clientId INTEGER NOT NULL, " +
                "FOREIGN KEY(clientId) REFERENCES Client(id))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropBankAccountTable() {
        String query = "DROP TABLE IF EXISTS BankAccount";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


