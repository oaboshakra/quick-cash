package com.example.quickcash;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import com.example.quickcash.ui.ProfileSuggestion.ProfileSuggestion;
import org.junit.Before;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import com.example.quickcash.util.AppConstants;

public class ProfileSuggestionTest {
    @Before
    public void launchActivity() {
        ActivityScenario.launch(ProfileSuggestion.class);
    }

    public void testNameDisplayed() {
        onView(withId(R.id.profileName)).check(matches(withText(AppConstants.Name)));
    }
    public void testEmailDisplayed() {
        onView(withId(R.id.profileEmail)).check(matches(withText(AppConstants.VALID_EMAIL)));
    }
}
