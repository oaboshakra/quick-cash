package com.example.quickcash;
import androidx.test.ext.junit.rules.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.action.ViewActions;

import com.example.quickcash.ui.Authentication.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RatingSubmissionEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testRatingSubmission() {
        // Assuming LoginActivity is the entry point where the employer logs in
        // Replace "R.id.username", "R.id.password", "R.id.login_button" with your actual IDs
        Espresso.onView(ViewMatchers.withId(R.id.username))
                .perform(ViewActions.typeText("employerUsername"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.password))
                .perform(ViewActions.typeText("employerPassword"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.login_button)).perform(ViewActions.click());

        // Navigate to rating screen and submit a rating
        // Replace "R.id.rate_employee_button" and others with your actual IDs
        Espresso.onView(ViewMatchers.withId(R.id.rate_employee_button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.rating_bar)).perform(ViewActions.swipeRight());
        Espresso.onView(ViewMatchers.withId(R.id.submit_rating_button)).perform(ViewActions.click());

        // Check for a confirmation message or any indication of successful submission
        // Replace "R.id.confirmation_message" with your actual ID
        Espresso.onView(ViewMatchers.withId(R.id.confirmation_message))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}

