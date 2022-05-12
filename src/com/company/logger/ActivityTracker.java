//Author: Bohdan Rudenko

package com.company.logger;

import com.company.database.entities.User;

import java.sql.Timestamp;

public class ActivityTracker {
    public static void userLogin() {
        User user = LoginTracker.getCurrentUser();
        String record = String.format("%s | %s logged in.", timestampNow(), user.getUsername());
        user.addActivity(record);
    }

    public static void userLogout() {
        User user = LoginTracker.getCurrentUser();
        String record = String.format("%s | %s logged out.", timestampNow(), user.getUsername());
        user.addActivity(record);
    }

    public static void userRegister() {
        User user = LoginTracker.getCurrentUser();
        String record = String.format("%s | %s registered.", timestampNow(), user.getUsername());
        user.addActivity(record);
    }

    private static String timestampNow() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }
}
