package com.example.quickcash;
import org.junit.Test;
import static org.junit.Assert.*;
import com.example.quickcash.ui.ProfileSuggestion.ProfileSuggestion;
public class ProfileSuggestionTest {

    @Test
    public void testNameIsString() {
        ProfileSuggestion profileSuggestion = new ProfileSuggestion();
        String employeeName = profileSuggestion.retrieveEmployeeName("Tyler");

        assertNotNull(employeeName);
        assertTrue(employeeName instanceof String);
    }
}
