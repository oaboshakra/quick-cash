package com.example.quickcash;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quickcash.ui.profile.EmployerProfile;
import com.example.quickcash.util.AppConstants;

import org.junit.Before;

public class profileLogicTest {
    private EmployerProfile employerProfile;

    @Before
    public void setUp() {
        employerProfile = new EmployerProfile();
    }

    @Test
    public void testValidIndustryType() {
        assertTrue(employerProfile.isValidIndustryType(AppConstants.VALID_INDUSTRIES[0]));
    }

    @Test
    public void testInvalidIndustryType() {
        assertFalse(employerProfile.isValidIndustryType("xyz"));
    }

    @Test
    public void testValidPhoneNum() {
        assertTrue(employerProfile.isValidPhoneNumber(AppConstants.PHONE_NO));
    }

    @Test
    public void testInvalidPhoneNum() {
        assertFalse(employerProfile.isValidPhoneNumber("89488"));
    }

    @Test
    public void testValidIdNumber() {
        assertTrue(employerProfile.isValidIdNumber(AppConstants.VALID_ID));
    }

    @Test
    public void testInvalidIdNumber() {
        assertFalse(employerProfile.isValidIdNumber("123"));
    }

    @Test
    public void testValidHiringStatus() {
        assertTrue(employerProfile.isValidHiringStatus(AppConstants.HIRING_STATUS));
    }

    @Test
    public void testInvalidHiringStatus() {
        assertFalse(employerProfile.isValidHiringStatus("xyz"));
    }
}
