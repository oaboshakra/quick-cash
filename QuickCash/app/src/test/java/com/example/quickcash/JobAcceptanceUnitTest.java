package com.example.quickcash;

import static org.junit.Assert.assertFalse;

import com.example.quickcash.util.DataValidator;

import org.junit.Test;

public class JobAcceptanceUnitTest {
    @Test
    public void TestisNotEmpty() {
        assertFalse(DataValidator.notNull(null));
    }
}
