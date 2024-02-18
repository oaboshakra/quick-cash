package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import com.example.quickcash.ui.profile.EmployerProfile;
import com.example.quickcash.util.AppConstants;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.assertFalse;

import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class ProfileUITest {

    ActivityScenario<EmployerProfile> employerProfileActivityScenario;

    @Before
    public void setUp(){

        employerProfileActivityScenario = ActivityScenario.launch(EmployerProfile.class);
        employerProfileActivityScenario.onActivity(activity -> {

        });
    }
    @Test
    public void testValidIndustry() {
        onView(withId(R.id.industryType)).perform(typeText("Painting"));
        onView(withId(R.id.industryType)).check(matches(withText("Painting")));
    }

    @Test
        public void testValidIDNum(){
        onView(withId(R.id.idNum)).perform(typeText("123456"));
        onView(withId(R.id.idNum)).check(matches(withText("123456")));
    }
    @Test
    public void testHiringStatus() {
        onView(withId(R.id.hiringStatus)).perform(typeText(AppConstants.VALID_HIRING_STATUS[0]));
        onView(withId(R.id.hiringStatus)).check(matches(withText(AppConstants.VALID_HIRING_STATUS[0])));
    }

    @Test
    public void testValidPhoneNum(){
        onView(withId(R.id.phoneNum)).perform(typeText("7199209"));
        onView(withId(R.id.phoneNum)).check(matches(withText("7199209")));
    }
}