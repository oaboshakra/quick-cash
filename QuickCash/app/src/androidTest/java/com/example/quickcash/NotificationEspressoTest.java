package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NotificationEspressoTest {

    ActivityScenario<MainActivity> activityScenario;

    @Before
    public void setUp(){

        activityScenario = ActivityScenario.launch(MainActivity.class);
        activityScenario.onActivity(activity -> {

        });

    }

    @Test
    public void testJobNotificationSameCity() {

        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.Location)).perform(typeText("Same City"));
        onView(withId(R.id.add)).perform(click());

    }

    @Test
    public void testJobNotificationNearbyCity() {

        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.Location)).perform(typeText("Nearby City"));
        onView(withId(R.id.add)).perform(click());

    }

    @Test
    public void testNoJobNotificationOutsideArea() {

        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.Location)).perform(typeText("Outside Area"));
        onView(withId(R.id.add)).perform(click());

    }

}
