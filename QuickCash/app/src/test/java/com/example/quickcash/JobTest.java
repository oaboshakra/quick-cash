package com.example.quickcash;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.quickcash.models.Job;

public class JobTest {

    private Job job;

    @Before
    public void setUp() {
        job = new Job("Software Engineer", "Develop and maintain software applications.");
    }

    @Test
    public void testJobCreation() {
        assertEquals("Software Engineer", job.getTitle());
        assertEquals("Develop and maintain software applications.", job.getDescription());
    }

    @Test
    public void testSetTitle() {
        job.setTitle("Senior Software Engineer");
        assertEquals("Senior Software Engineer", job.getTitle());
    }

    @Test
    public void testSetDescription() {
        job.setDescription("Lead the development of software applications.");
        assertEquals("Lead the development of software applications.", job.getDescription());
    }
}
