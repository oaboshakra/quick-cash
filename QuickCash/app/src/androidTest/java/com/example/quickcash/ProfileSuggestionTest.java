package com.example.quickcash;
import com.example.quickcash.ui.ProfileSuggestion.ProfileSuggestion;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;

@LargeTest
public class ProfileSuggestionTest {

    @Rule
    public ActivityScenarioRule<ProfileSuggestion> activityRule =
            new ActivityScenarioRule<>(ProfileSuggestion.class);
    @Test
    public void testRecyclerViewDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.employee_recyclerView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
