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


import com.example.quickcash.ui.Job.ApplyJobActivity;
import com.example.quickcash.util.AppConstants;
import com.google.firebase.FirebaseApp;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static org.junit.Assert.assertFalse;
import org.junit.runner.RunWith;


public class ApplyJobEspressoTest {
    ActivityScenario<ApplyJobActivity> activityScenario;

    @Before
    public void setUp(){
        activityScenario = ActivityScenario.launch(ApplyJobActivity.class);
        activityScenario.onActivity(activity -> {

        });
    }

    @Test
    public void testInvalidName() {
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.INVALID_NAME));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.VALID_PHONE));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.INVALID_NAME_MESSAGE)));
    }

    @Test
    public void testInvalidPhone() {
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.VALID_NAME));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.INVALID_PHONE));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.INVALID_PHONE_MESSAGE)));
    }

    @Test
    public void testInvalidEmail() {
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.VALID_NAME));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.VALID_PHONE));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.INVALID_EMAIL));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.INVALID_EMAIL_MESSAGE)));
    }

    @Test
    public void testEmptyName(){
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.VALID_PHONE));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }

    @Test
    public void testEmptyPhone(){
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.VALID_NAME));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }

    @Test
    public void testEmptyEmail(){
        onView(withId(R.id.apply_Name)).perform(typeText(AppConstants.VALID_NAME));
        onView(withId(R.id.apply_Phone)).perform(typeText(AppConstants.VALID_PHONE));
        onView(withId(R.id.apply_Email)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.apply_btn)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }
}

