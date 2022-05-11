package com.company.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String urlSQLite = "jdbc:sqlite:easyLang.sqlite";
    private static Connection connection;

    static {
        try {
            Driver driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " +
                    e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(urlSQLite);
            System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " +
                    e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
