package com.example.quickcash;
import org.junit.Test;
import static org.junit.Assert.*;
import com.example.quickcash.ui.submitJob.submitJob;
public class submitJobLogicTest {
        @Test
        public void testValidJobName() {
            assertTrue(submitJob.isValidJobName("abc"));
        }

        @Test
        public void testInvalidJobName() {
            assertFalse(submitJob.isValidJobName("123"));
        }

        @Test
        public void testValidHoursRequired() {
            assertTrue(submitJob.isValidHoursRequired("12"));
        }

        @Test
        public void testInvalidHoursRequired() {
            assertFalse(submitJob.isValidHoursRequired("ab"));
        }

        @Test
        public void testValidCategory() {
            assertTrue(submitJob.isValidCategory("abc"));
        }

        @Test
        public void testInvalidCategory() {
            assertFalse(submitJob.isValidCategory("123"));
        }

        @Test
        public void testValidPay() {
            assertTrue(submitJob.isValidPay("12"));
        }

        @Test
        public void testInvalidPay() {
            assertFalse(submitJob.isValidPay("ab"));
        }
    }

