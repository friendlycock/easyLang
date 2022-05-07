package com.company.database;

import com.company.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String urlSQLite = "jdbc:sqlite:easyLang.sqlite";

    private static Connection connection;
    private static UserDAO instance = null;

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

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                User user = getUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

//    public static void main(String[] args) {
//        UsersDAO dao = new UsersDAO();
//        User user1 = new User(1, "krampus", "krampus1337@gmail.com", "password123",
//                "A", "English", "German");
//        User user2 = new User(2, "krampus1", "krampus1338@gmail.com", "password123",
//                "A", "English", "German");
//        dao.insertUpdateUser(user1);
////        dao.insertUpdateUser(user2);
////        dao.getAllUsers().forEach(System.out::println);
////        System.out.println(dao.getUserByEmail("krampus1mail.com"));
//    }

    public User getUserByEmail(String email) {
        User user = new User();

        try {
            Statement statement = connection.createStatement();
            String SQL = String.format("SELECT * FROM Users WHERE email = '%s'", email);
            ResultSet resultSet = statement.executeQuery(SQL);

            user = getUserFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void insertUpdateUser(User user) {
        try{
            Statement statement = connection.createStatement();
            String SQL = String.format("INSERT INTO Users VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s')",
                    user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
                    user.getUserLevel(), user.getUserLanguage(), user.getUserPracticeLanguage());
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setUserLevel(resultSet.getString("level"));
        user.setUserLanguage(resultSet.getString("language"));
        user.setUserPracticeLanguage(resultSet.getString("practiseLanguage"));

        return user;
    }
}
