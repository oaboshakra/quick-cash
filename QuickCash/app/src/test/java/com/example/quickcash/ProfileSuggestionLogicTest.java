package com.example.quickcash;

import org.junit.Test;
import com.example.quickcash.models.User;
import static org.junit.Assert.assertEquals;

public class ProfileSuggestionLogicTest {
    @Test
    public void testUserGettersAndSetters() {
        User user = new User();
        user.setFirstName("Sitish");
        user.setLastName("John");
        user.setEmail("sitish.john@email.com");
        user.setPassword("password");
        user.setRole("user");

        assertEquals("Sitish", user.getFirstName());
        assertEquals("John", user.getLastName());
        assertEquals("sitish.john@email.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("user", user.getRole());
    }
}