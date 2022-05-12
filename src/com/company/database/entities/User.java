package com.company.database.entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private static final String emailRegex = "^(.+)@(.+)$"; //pattern to check if email is valid
    private static final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$"; //pattern to check if password is valid
    private static int newId = 0;

    private int id;
    private String username;
    private String email;
    private String password;
    private String userLevel;
    private String userLanguage;
    private String userPracticeLanguage;
    private boolean isAdmin;
    private ArrayList<String> userActivity = new ArrayList<>();
    private String accessedTopics = "";
    private String completedTopics = "";

    public User(String username, String email, String password, String userLevel, String userLanguage, String userPracticeLanguage) {
        this.id = newId;
        newId++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userLevel = userLevel;
        this.userLanguage = userLanguage;
        this.userPracticeLanguage = userPracticeLanguage;
        this.isAdmin = false;
    }

    public User(String username, String email, String password, String userLevel, String userLanguage, String userPracticeLanguage, boolean isAdmin) {
        this.id = newId;
        newId++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userLevel = userLevel;
        this.userLanguage = userLanguage;
        this.userPracticeLanguage = userPracticeLanguage;
        this.isAdmin = isAdmin;
    }

    public User() {
        this.id = newId;
        newId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getUserPracticeLanguage() {
        return userPracticeLanguage;
    }

    public void setUserPracticeLanguage(String userPracticeLanguage) {
        this.userPracticeLanguage = userPracticeLanguage;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public ArrayList<String> getUserActivity() {
        return userActivity;
    }

    public void setUserActivity(ArrayList<String> userActivity) {
        this.userActivity = userActivity;
    }

    public void addActivity(String activity) {
        userActivity.add(activity);
    }

    public static boolean emailIsValid(String email) {

        //initialize the Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        //searching for occurrences of regex
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean passwordIsValid(String password)
    {
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void addAccessedTopic(int topicId) {
        accessedTopics += topicId + " ";
    }

    public void addCompletedTopic(int topicId) {
        completedTopics += topicId + " ";
    }

    public String getAccessedTopics() {
        return accessedTopics;
    }

    public int[] getAccessedTopicsCount() {
        int[] resultArray = new int[63];
        String[] topics = accessedTopics.split(" ");

        for (String topic : topics) {
            resultArray[Integer.parseInt(topic)] += 1;
        }

        return resultArray;
    }

    public int[] getCompletedTopicsCount() {
        int[] resultArray = new int[63];
        String[] topics = completedTopics.split(" ");

        for (String topic : topics) {
            resultArray[Integer.parseInt(topic)] += 1;
        }

        return resultArray;
    }

    public String getCompletedTopics() {
        return completedTopics;
    }

    public void setAccessedTopics(String accessedTopics) {
        this.accessedTopics = accessedTopics;
    }

    public void setCompletedTopics(String completedTopics) {
        this.completedTopics = completedTopics;
    }

    @Override
    public String toString() {
        StringBuilder activities = new StringBuilder();
        for (String activity: userActivity) {
            activities.append(activity).append("<br>");
        }

        StringBuilder accessedTopic = new StringBuilder();
        if (!accessedTopics.contains("none")) {
            int[] accessedTopicCount = getAccessedTopicsCount();

            for (int i = 0; i < accessedTopicCount.length; i++) {
                if (accessedTopicCount[i] != 0 ) {
                    accessedTopic.append(String.format("Topic %d: %d times<br>",i, accessedTopicCount[i]));
                }
            }
        }

        StringBuilder completedTopic = new StringBuilder();
        if (!completedTopics.contains("none")) {
            int[] completedTopicCount = getAccessedTopicsCount();

            for (int i = 0; i < completedTopicCount.length; i++) {
                if (completedTopicCount[i] != 0 ) {
                    completedTopic.append(String.format("Topic %d: %d times<br>",i, completedTopicCount[i]));
                }
            }
        }

        return "id=" + id + "<br>" +
                "username= " + username + "<br>" +
                "email=" + email + "<br>" +
                "userLevel= " + userLevel + "<br>" +
                "userLanguage= " + userLanguage + "<br>" +
                "userPracticeLanguage= " + userPracticeLanguage + "<br>" +
                "isAdmin= " + isAdmin + "<br>" +
                "Accessed topics: <br>" + accessedTopic.toString() +
                "Completed topics: <br>" + completedTopic.toString() +
                "User's activity: <br>" + activities.toString();
    }
}
