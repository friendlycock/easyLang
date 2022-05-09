package com.company;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userLanguage='" + userLanguage + '\'' +
                ", userPracticeLanguage='" + userPracticeLanguage + '\'' +
                '}';
    }
}
