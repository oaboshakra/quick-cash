package com.example.quickcash.ui.notifications;

public class JobNotification {

    public static boolean shouldSendNotification(String userLocation, String jobLocation) {

        if (userLocation.equals(jobLocation)) {
            return true;
        } else if (isNearbyCity(userLocation, jobLocation)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNearbyCity(String userLocation, String jobLocation) {

        return false;

    }

}

