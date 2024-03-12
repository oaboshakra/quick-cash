package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import com.example.quickcash.ui.Job.JobAcceptance;
import com.example.quickcash.util.AppConstants;
import com.google.firebase.FirebaseApp;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static org.junit.Assert.assertFalse;
import org.junit.runner.RunWith;

public class JobAcceptanceEspressoTest {

    ActivityScenario<JobAcceptance> activityScenario;

    @Before
    public void setUp(){
        activityScenario = ActivityScenario.launch(JobAcceptance.class);
        activityScenario.onActivity(activity -> {

        });
    }

    @Test
    public void testJobAcceptance() {
        onView(withId(R.id.job_search)).perform(typeText(AppConstants.Name));
        onView(withId(R.id.acceptance_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.Acceptance)));
    }

    @Test
    public void testJobCompletion() {
        onView(withId(R.id.job_search)).perform(typeText(AppConstants.Name));
        onView(withId(R.id.completion_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.Completion)));
    }
}
