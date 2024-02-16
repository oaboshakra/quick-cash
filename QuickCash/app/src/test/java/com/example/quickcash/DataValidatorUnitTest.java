package com.example.quickcash;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quickcash.util.DataValidator;

public class DataValidatorUnitTest {

    @Test
    public void TestnotNull1() {
        assertTrue(DataValidator.notNull("someValue"));
    }
    @Test
    public void TestnotNull2() {
        assertFalse(DataValidator.notNull(null));
    }

    @Test
    public void TestisValidEmail1() {
        assertTrue(DataValidator.isValidEmail("user@example.com"));
    }

    @Test
    public void TestisValidEmail2() {
        assertFalse(DataValidator.isValidEmail("invalidEmail@"));
    }


    @Test
    public void TestisValidPassword1() {
        assertTrue(DataValidator.isValidPassword("StrongPassword123"));
    }

    @Test
    public void  TestisValidPassword2() {
        assertFalse(DataValidator.isValidPassword("WeakPwd"));
    }

    @Test
    public void TestmatchesConfirmPassword1(){
        assertTrue(DataValidator.matchesConfirmPassword("password" , "password"));
    }
    @Test
    public void TestmatchesConfirmPassword2(){
        assertFalse(DataValidator.matchesConfirmPassword("passwoed" , "aieufbsdbfbdf"));
    }

    @Test
    public void TestisValidName1() { assertTrue(DataValidator.isValidName("Good name")); }

    @Test
    public void TestisValidName2() { assertFalse(DataValidator.isValidName("BAD@NAME23")); }
    @Test
    public void TestisValidPhone1() { assertTrue(DataValidator.isValidPhone("123 456 5555")); }

    @Test
    public void TestisValidPhone2() { assertFalse(DataValidator.isValidPhone("BadPhone123")); }
}
