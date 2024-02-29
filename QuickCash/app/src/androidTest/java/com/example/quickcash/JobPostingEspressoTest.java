package com.example.quickcash;

import androidx.navigation.NavController;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import com.example.quickcash.ui.JobPosting.PostJobFragment;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class JobPostingEspressoTest{

    @Rule
    public ActivityScenarioRule<PostJobFragment> activityScenarioRule =
            new ActivityScenarioRule<>(PostJobFragment.class);

    @Test
    public void testJobNameEditTextVisibilityAndHint() {
        Espresso.onView(ViewMatchers.withId(R.id.etJobName))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withHint("Job Name")));
    }

    @Test
    public void testHoursRequiredEditTextVisibilityAndHint() {
        Espresso.onView(ViewMatchers.withId(R.id.etHoursRequired))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withHint("Hours Required")));
    }

    @Test
    public void testHourlyWageEditTextVisibilityAndHint() {
        Espresso.onView(ViewMatchers.withId(R.id.etHourlyWage))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withHint("Hourly Wage (in dollars)")));
    }

    @Test
    public void testSkillsNeededEditTextVisibilityAndHint() {
        Espresso.onView(ViewMatchers.withId(R.id.etSkillsNeeded))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withHint("Skills Needed")));
    }

    @Test
    public void testCreateJobButtonVisibilityAndText() {
        Espresso.onView(ViewMatchers.withId(R.id.btnCreateJob))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withText("Create Job")));
    }
//    @Test
//    public void testCreateJobButtonClick() {
//        // Mock NavController
//        NavController navController = Mockito.mock(NavController.class);
//
//        // Inject mock NavController into the activity
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            activity.setNavController(navController);
//        });
//
//        // Perform button click
//        Espresso.onView(ViewMatchers.withId(R.id.)).perform(ViewActions.click());
//
//        // Verify that the NavController was called to navigate to the expected destination
//        Mockito.verify(navController).navigate(R.id.action_jobPostingFragment_to_newActivity);
//    }


}
