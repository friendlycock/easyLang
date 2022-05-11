package com.company.logger;

import com.company.database.entities.User;

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
