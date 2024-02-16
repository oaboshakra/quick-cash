package com.example.quickcash.ui.display;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quickcash.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class JobListingsDisplayTest {

    @Rule
    public ActivityScenarioRule<JobListingsDisplay> activityRule =
            new ActivityScenarioRule<>(JobListingsDisplay.class);

    @Test
    public void testRecyclerViewVisibility() {
        Espresso.onView(withId(R.id.jobsRecyclerView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testApplyButton_clickable() {

    }
}
