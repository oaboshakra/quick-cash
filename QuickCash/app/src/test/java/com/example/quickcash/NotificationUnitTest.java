package com.example.quickcash;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificationUnitTest {

    private NotificationUnitTest notificationService;

    @Before
    public void setUp() {
        notificationService = new NotificationUnitTest();
    }

    @Test
    public void testSendNotificationSameCity() {
        String userLocation = "Current City";
        String jobLocation = "Current City";

        boolean result = notificationService.shouldSendNotification(userLocation, jobLocation);

        assertEquals(true, result);
    }

    @Test
    public void testSendNotificationNearbyCity() {
        String userLocation = "Current City";
        String jobLocation = "Nearby City";

        boolean result = notificationService.shouldSendNotification(userLocation, jobLocation);

        assertEquals(true, result);
    }

    @Test
    public void testNoSendNotificationOutsideArea() {
        String userLocation = "Current City";
        String jobLocation = "Outside Area";

        boolean result = notificationService.shouldSendNotification(userLocation, jobLocation);

        assertEquals(false, result);
    }
}

