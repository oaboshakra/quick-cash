package com.example.quickcash;
import androidx.test.espresso.IdlingResource;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import com.example.quickcash.ui.Authentication.LoginActivity;
import com.example.quickcash.util.AppConstants;
import com.google.firebase.FirebaseApp;


public class LoginEspressoTest {

    ActivityScenario<LoginActivity> activityScenario;

    @Before
    public void setUp(){



        activityScenario = ActivityScenario.launch(LoginActivity.class);
        activityScenario.onActivity(activity -> {

        });
    }
    @Test
    public void testInvalidEmail() {
         onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.INVALID_EMAIL));
         onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.VALID_PASSWORD));
         onView(withId(R.id.Sign_In_Request)).perform(click());
         onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.INVALID_EMAIL_MESSAGE)));
    }
    @Test
    public void testInvalidPassword(){
        onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.INVALID_PASSWORD));
        onView(withId(R.id.Sign_In_Request)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.INVALID_PASSWORD_MESSAGE)));
    }
    @Test
    public void testEmptyPassword(){
        onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.VALID_EMAIL));
        onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.Sign_In_Request)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }
    @Test
    public void testEmptyEmail(){
        onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.VALID_PASSWORD));
        onView(withId(R.id.Sign_In_Request)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }

    @Test
    public void testEmailPasswordEmpty(){
        onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.EMPTY_STRING));
        onView(withId(R.id.Sign_In_Request)).perform(click());
        onView(withId(R.id.statusLabel)).check(matches(withText(AppConstants.FIELD_EMPTY_MESSAGE)));
    }

//    @Test
//    public void testValidPasswordEmail(){
//        onView(withId(R.id.Sign_In_Email)).perform(typeText(AppConstants.VALID_EMAIL));
//        onView(withId(R.id.Sign_In_Password)).perform(typeText(AppConstants.VALID_PASSWORD));
//        onView(withId(R.id.Sign_In_Request)).perform(click());
//        onView(withId(R.id.statusLabel)).check(matches(withText(" ")));
//    }
}










