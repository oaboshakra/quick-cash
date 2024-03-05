package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quickcash.R;
import com.example.quickcash.ui.Profile.EmployerProfile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ProfileUITest {

    private static final String INDUSTRY_TYPE = "Technology";
    private static final String ID_NUMBER = "123456";
    private static final String HIRING_STATUS = "Yes";
    private static final String PHONE_NUMBER = "1234567890";

    @Before
    public void launchActivity() {
        ActivityScenario.launch(EmployerProfile.class);
    }

    @Test
    public void testIndustryTypeInput() {
        Espresso.onView(withId(R.id.industryTypeTitle)).perform(typeText(INDUSTRY_TYPE), closeSoftKeyboard());
        Espresso.onView(withId(R.id.industryTypeTitle)).check(matches(withText(INDUSTRY_TYPE)));
    }

    @Test
    public void testIdNumberInput() {
        Espresso.onView(withId(R.id.idNumTitle)).perform(typeText(ID_NUMBER), closeSoftKeyboard());
        Espresso.onView(withId(R.id.idNumTitle)).check(matches(withText(ID_NUMBER)));
    }

    @Test
    public void testHiringStatusInput() {
        Espresso.onView(withId(R.id.hiringStatusTitle)).perform(typeText(HIRING_STATUS), closeSoftKeyboard());
        Espresso.onView(withId(R.id.hiringStatusTitle)).check(matches(withText(HIRING_STATUS)));
    }

    @Test
    public void testPhoneNumberInput() {
        Espresso.onView(withId(R.id.phoneNumTitle)).perform(typeText(PHONE_NUMBER), closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneNumTitle)).check(matches(withText(PHONE_NUMBER)));
    }
}

