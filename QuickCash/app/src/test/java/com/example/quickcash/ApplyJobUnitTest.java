package com.example.quickcash;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quickcash.util.DataValidator;
public class ApplyJobUnitTest {

    @Test
    public void TestisValidName1() { assertTrue(DataValidator.isValidName("Good name")); }

    @Test
    public void TestisValidName2() { assertFalse(DataValidator.isValidName("BAD@NAME23")); }
    @Test
    public void TestisValidPhone1() { assertTrue(DataValidator.isValidPhone("123 456 5555")); }

    @Test
    public void TestisValidPhone2() { assertFalse(DataValidator.isValidPhone("BadPhone123")); }
}