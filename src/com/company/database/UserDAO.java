package com.company.database;

import com.company.database.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {

    private static final Connection connection = DatabaseConnection.getConnection();
    private static UserDAO instance = null;


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

    public boolean checkUserExistence(String username, String email) { //NEED TO TEST
        try {
            Statement statement = connection.createStatement();
            String SQL = String.format("SELECT * FROM Users WHERE username = '%s'", username);
            String SQL2 = String.format("SELECT * FROM Users WHERE email = '%s'", email);
            ResultSet resultSet = statement.executeQuery(SQL);
            ResultSet resultSet2 = statement.executeQuery(SQL2);
            if (resultSet != null || resultSet2 != null) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

//    public static void main(String[] args) {
//        UserDAO dao = new UserDAO();
//        User user1 = new User("krampus", "krampus1337@gmail.com", "password123",
//                "A", "English", "German");
//        User user2 = new User("krampus1", "krampus1338@gmail.com", "password123",
//                "A", "English", "German");
//        dao.insertUpdateUser(user1);
//        dao.insertUpdateUser(user2);
//        System.out.println(dao.getUserByEmail("nonexistemail"));
//    }

    public User getUserByEmail(String email) {
        User user = new User();

        try {
            String SQL = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            user = getUserFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void insertUpdateUser(User user) {
        try{
            String SQL = "INSERT OR REPLACE INTO Users VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            StringBuilder activities = new StringBuilder();
            for (String record: user.getUserActivity()) {
                activities.append(record).append("\n");
            }

            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserLanguage());
            statement.setString(6, user.getUserLevel());
            statement.setString(7, user.getUserPracticeLanguage());
            statement.setBoolean(8, user.isAdmin());
            statement.setString(9, activities.toString());
            statement.executeUpdate();


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
        user.setUserPracticeLanguage(resultSet.getString("practiceLanguage"));
        user.setAdmin(resultSet.getBoolean("isAdmin"));

        String[] activities = resultSet.getString("activity").split("\n");
        ArrayList<String> activityList = new ArrayList<>(Arrays.asList(activities));
        user.setUserActivity(activityList);

        return user;
    }
}
