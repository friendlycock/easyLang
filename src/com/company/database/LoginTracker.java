package com.company.database;

public class LoginTracker {
    private static User currentUser = null;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        LoginTracker.currentUser = currentUser;
    }

    public static void logOff() {
        LoginTracker.currentUser = null;
    }
}
