//Author: Bohdan Rudenko

package com.company.database;

import com.company.database.entities.Topic;
import com.company.logger.LoginTracker;

import java.sql.*;
import java.util.ArrayList;

public class TopicDAO {
    private static final Connection connection = DatabaseConnection.getConnection();
    private static TopicDAO instance = null;


    public static TopicDAO getInstance() {
        if (instance == null) {
            instance = new TopicDAO();
        }
        return instance;
    }

    private TopicDAO() {

    }


    public static ArrayList<Topic> getTopicsByLevel(String level) {
        ArrayList<Topic> topics = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Topics JOIN Text ON (Topics.id = Text.id) WHERE level = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, level);
            ResultSet resultSet = statement.executeQuery();
            topics = getTopicsFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return topics;
    }

    private static ArrayList<Topic> getTopicsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Topic> topicsList = new ArrayList<>();
        while (resultSet.next()) {
            Topic topic = new Topic();

            topic.setId(resultSet.getInt("id"));
            topic.setContext(resultSet.getString("context"));
            topic.setSubContext(resultSet.getString("subContext"));
            topic.setGrammar(resultSet.getString("grammar"));
            topic.setKeyVocab(resultSet.getString("keyVocab"));
            topic.setText(resultSet.getString("text"));
            topic.setSpanishKeywords(resultSet.getString("Spanish"));
            topicsList.add(topic);
        }

        return topicsList;
    }

    public static Topic getTopicById(int id) {
        Topic topic = new Topic();
        try {
            String SQL = "SELECT * FROM Topics JOIN Text ON (Topics.id = Text.id) WHERE grammar = ? AND level = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            topic = getTopicsFromResultSet(resultSet).get(0);
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return topic;
    }

    public static ArrayList<String> getTopicContextAndSubcontext(int topicId) {
        ArrayList<String> contextSubcontext = new ArrayList<>();

        try {
            String SQL = "SELECT context, subContext FROM Topics WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, topicId);
            ResultSet resultSet = statement.executeQuery();
            contextSubcontext.add(resultSet.getString("context"));
            contextSubcontext.add(resultSet.getString("subContext"));
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return contextSubcontext;
    }

}
