package com.example.quickcash;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;

import com.example.quickcash.util.AppConstants;
import com.example.quickcash.ui.preferenceSystem.preferenceSystem;
import org.junit.Before;

public class preferenceSystemUITest {

    @Before
    public void launchActivity() {
        ActivityScenario.launch(preferenceSystem.class);
    }

    public void testNameDisplayed() {
        onView(withId(R.id.name)).check(matches(withText(AppConstants.Name)));
    }
    public void testTimeZoneDisplayed() {
        onView(withId(R.id.TimeZone)).check(matches(withText(AppConstants.TimeZOne)));
    }
    public void testWageDisplayed() {
        onView(withId(R.id.Wage)).check(matches(withText(AppConstants.wage)));
    }
    public void testLocationDisplayed() {
        onView(withId(R.id.Location)).check(matches(withText(AppConstants.Location)));;
    }

}
