//Author: Bohdan Rudenko

package com.company.database;

import com.company.database.entities.User;
import com.company.logger.LoginTracker;

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
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    public User getUserByEmail(String email) {
        User user = new User();

        try {
            String SQL = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            user = getUserFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void insertUpdateUser(User user) {
        try{
            String SQL = "INSERT OR REPLACE INTO Users VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            statement.setString(10, user.getAccessedTopics());
            statement.setString(11, user.getCompletedTopics());

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
        user.setAccessedTopics(resultSet.getString("accessed_topics"));
        user.setCompletedTopics(resultSet.getString("completed_topics"));

        String[] activities = resultSet.getString("activity").split("\n");
        ArrayList<String> activityList = new ArrayList<>(Arrays.asList(activities));
        user.setUserActivity(activityList);

        return user;
    }

    public String getUserSalt(int id) {
        String SQL = "SELECT salt from Salt WHERE salt_id = ?";
        String salt = "";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            salt = resultSet.getString("salt");
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return salt;
    }

    public void insertUpdateSalt(String salt) {
        String SQL = "INSERT OR REPLACE INTO Salt VALUES(?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, LoginTracker.getCurrentUser().getId());
            statement.setString(2, salt);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
