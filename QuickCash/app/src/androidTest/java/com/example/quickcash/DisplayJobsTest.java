package com.example.quickcash;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class JobRecommendationsEspressoTest {

    @Rule
    public ActivityTestRule<JobRecommendationsActivity> activityRule =
            new ActivityTestRule<>(JobRecommendationsActivity.class);

    @Test
    public void jobListingsAreDisplayed() {
        // Check if the job listings RecyclerView is displayed
        onView(withId(R.id.rvJobListings)).check(matches(isDisplayed()));
    }

    @Test
    public void clickApplyOnFirstJob() {
        // Perform a click on the apply button for the first job listing
        onView(withId(R.id.rvJobListings))
                .perform(actionOnItemAtPosition(0, click()));

        // Check if the application sent confirmation Toast is displayed
        onView(withText(R.string.application_sent_confirmation)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}
