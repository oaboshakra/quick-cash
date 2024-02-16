package com.example.quickcash.models;

import java.io.Serializable;

public class Job implements Serializable {
    private String title;
    private String description;

    // Default constructor is needed for Firebase data mapping
    public Job() {}

    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

