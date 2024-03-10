package com.example.quickcash;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;

import com.example.quickcash.ui.preferenceSystem.preferenceSystem;

import org.junit.Before;

public class ProfileSuggestionTest {

    @Before
    public void launchActivity() {
        ActivityScenario.launch(preferenceSystem.class);
    }

}
