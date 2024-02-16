package com.example.quickcash;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SubmitJobTest {



    @Before
    public void setUp() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_submit_job)).perform(ViewActions.click());
    }

    @Test
    public void testEmptyEntry() {
        Espresso.onView(ViewMatchers.withId(R.id.submitButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("Please fill in all fields")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testValidHoursRequiredEntry() {

        Espresso.onView(ViewMatchers.withId(R.id.hoursRequiredEditText)).perform(ViewActions.typeText("8"));

        Espresso.onView(ViewMatchers.withId(R.id.submitButton)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("Valid")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void testValidJobNameEntry() {

        Espresso.onView(ViewMatchers.withId(R.id.jobNameEditText)).perform(ViewActions.typeText("Accountant"));

        Espresso.onView(ViewMatchers.withId(R.id.submitButton)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("Valid")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }


}

