package com.example.quickcash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobPostUnit {

    private PostJobFragment postJobFragment;

    @Before
    public void setUp() {
        postJobFragment = new PostJobFragment();
    }

    @Test
    public void validateInputFields_emptyJobName_shouldReturnFalse() {

        postJobFragment.etJobName.setText("");


        boolean result = postJobFragment.validateInputFields();


        assertFalse(result);
    }

    @Test
    public void validateInputFields_emptyHoursRequired_shouldReturnFalse() {

        postJobFragment.etJobName.setText("Job Title");
        postJobFragment.etHoursRequired.setText("");


        boolean result = postJobFragment.validateInputFields();


        assertFalse(result);
    }

    @Test
    public void validateInputFields_emptyHourlyWage_shouldReturnFalse() {

        postJobFragment.etJobName.setText("Job Title");
        postJobFragment.etHoursRequired.setText("8");
        postJobFragment.etHourlyWage.setText("");


        boolean result = postJobFragment.validateInputFields();


        assertFalse(result);
    }

    @Test
    public void validateInputFields_emptySkillsNeeded_shouldReturnFalse() {

        postJobFragment.etJobName.setText("Job Title");
        postJobFragment.etHoursRequired.setText("8");
        postJobFragment.etHourlyWage.setText("20");
        postJobFragment.etSkillsNeeded.setText("");


        boolean result = postJobFragment.validateInputFields();


        assertFalse(result);
    }

    @Test
    public void validateInputFields_nonEmptyFields_shouldReturnTrue() {

        postJobFragment.etJobName.setText("Job Title");
        postJobFragment.etHoursRequired.setText("8");
        postJobFragment.etHourlyWage.setText("20");
        postJobFragment.etSkillsNeeded.setText("Skills");


        boolean result = postJobFragment.validateInputFields();


        assertTrue(result);
    }
}
