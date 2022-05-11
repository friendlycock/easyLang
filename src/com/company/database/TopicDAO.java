package com.company.database;

import com.company.database.entities.Topic;

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

    public static ArrayList<Topic> getTopicsByContext(String context) {
        ArrayList<Topic> topics = new ArrayList<>();

        try {
            String SQL = "SELECT * FROM Topics JOIN Text ON (Topics.id = Text.id) WHERE context = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, context);
            ResultSet resultSet = statement.executeQuery();
            topics = getTopicsFromResultSet(resultSet);
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

    public static void main(String[] args) {
        getTopicsByContext("Making Appointments").forEach(System.out::println);
    }

}
