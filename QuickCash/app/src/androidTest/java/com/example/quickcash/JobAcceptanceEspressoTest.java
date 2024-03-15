package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.Espresso;
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
    private static final String test = "killer";
    private static final String Cancel = "Cancel";
    private static final String Acceptance = "Acceptance";
    private static final String Completion = "Completion";
    @Before
    public void setUp(){
        activityScenario = ActivityScenario.launch(JobAcceptance.class);
        activityScenario.onActivity(activity -> {

        });
    }
    @Test
    public void testJobCancel() {
        Espresso.onView(withId(R.id.searchName)).perform(typeText(test), closeSoftKeyboard());
        onView(withId(R.id.search_btn)).perform(click());
        onView(withId(R.id.cancel_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(Cancel)));
    }

    @Test
    public void testJobAcceptance() {
        Espresso.onView(withId(R.id.searchName)).perform(typeText(test), closeSoftKeyboard());
        onView(withId(R.id.search_btn)).perform(click());
        onView(withId(R.id.acceptance_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(Acceptance)));
    }

    @Test
    public void testJobCompletion() {
        Espresso.onView(withId(R.id.searchName)).perform(typeText(test), closeSoftKeyboard());
        onView(withId(R.id.search_btn)).perform(click());
        onView(withId(R.id.completion_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(Completion)));
    }
}
