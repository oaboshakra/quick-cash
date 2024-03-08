package com.example.quickcash;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeNotificationJUnitTest {

    private NotificationService notificationService;

    @Before
    public void setUp() {
        notificationService = new NotificationService(); // Initialize your notification service here
    }

    @Test
    public void testEmployeeReceivesNotification() {
        // Simulate rating submission and check if notification is sent to the employee
        boolean isNotified = notificationService.notifyEmployee("employeeId", "Your new rating is now available.");

        // Assert that the employee is notified
        assertTrue("Employee should receive notification", isNotified);
    }
}

