//package com.example.quickcash;
//
//public class ProfileLogicTest {
//}

package com.example.quickcash;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quickcash.ui.Profile.EmployerProfile;
import com.example.quickcash.util.AppConstants;

public class ProfileLogicTest {

    @Test
    public void testValidIndustryType() {
        assertTrue(EmployerProfile.isValidIndustryType(AppConstants.VALID_INDUSTRIES[0]));
    }

    @Test
    public void testInvalidIndustryType() {
        assertFalse(EmployerProfile.isValidIndustryType("xyz"));
    }

    @Test
    public void testValidPhoneNum() {
        assertTrue(EmployerProfile.isValidPhoneNumber("7199209"));
    }

    @Test
    public void testInvalidPhoneNum() {
        assertFalse(EmployerProfile.isValidPhoneNumber("98237"));
    }

    @Test
    public void testValidIdNumber() {
        assertTrue(EmployerProfile.isValidIdNumber("123456"));
    }

    @Test
    public void testInvalidIdNumber() {
        assertFalse(EmployerProfile.isValidIdNumber("P"));
    }

    @Test
    public void testValidHiringStatus() {
        assertTrue(EmployerProfile.isValidHiringStatus(AppConstants.VALID_HIRING_STATUS[0]));
    }

    @Test
    public void testInvalidHiringStatus() {
        assertFalse(EmployerProfile.isValidHiringStatus("xyz"));
    }
}
