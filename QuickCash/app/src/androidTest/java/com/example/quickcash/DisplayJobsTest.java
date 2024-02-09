package com.example.quickcash;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.quickcash.ui.JobListingsDisplay;
import com.example.quickcash.util.AppConstants;

@RunWith(AndroidJUnit4.class)
public class DisplayJobsTest {

    ActivityScenario<JobListingsDisplay> activityScenario;

    @Before
    public void setUp() {
        // Assuming JobListingsDisplay is the activity that shows the job listings after search/filter
        activityScenario = ActivityScenario.launch(JobListingsDisplay.class);
        activityScenario.onActivity(activity -> {
            // Perform additional setup if necessary
        });
    }

    @Test
    public void testJobSearchFlow() {
        // Assuming R.id.search_input is the input field where users enter job search queries
        onView(withId(R.id.search_input)).perform(typeText("Engineer"));

        // Assuming R.id.search_button is the button clicked to search for jobs
        onView(withId(R.id.search_button)).perform(click());

        // Assuming R.id.job_listings is the id for the list of job listings
        onView(withId(R.id.job_listings)).check(matches(isDisplayed()));
    }

    @Test
    public void testJobApply() {
        // We simulate that the user has already searched and the jobs are listed.
        // Assuming R.id.apply_button is the apply button for the first job listing
        onView(withId(R.id.apply_button)).perform(click());

        // Assuming R.id.application_sent_confirmation is the id for a confirmation message or view
        onView(withId(R.id.application_sent_confirmation)).check(matches(withText(AppConstants.APPLICATION_SENT_MESSAGE)));
    }

    @Test
    public void testFilterJobs() {
        // Assuming R.id.filter_options_button is the button clicked to apply filters
        onView(withId(R.id.filter_options_button)).perform(click());

        // Selecting a filter option
        // Assuming R.id.location_filter is the id for a dropdown to select location filter
        onView(withId(R.id.location_filter)).perform(click());
        onView(withText("New York")).perform(click());

        // Applying the filter
        // Assuming R.id.apply_filter_button is the button clicked to apply the selected filters
        onView(withId(R.id.apply_filter_button)).perform(click());

        // Checking if the filtered job listings are displayed
        onView(withId(R.id.job_listings)).check(matches(isDisplayed()));
    }


}
