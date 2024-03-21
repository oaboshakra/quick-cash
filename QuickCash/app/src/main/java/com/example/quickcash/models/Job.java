package com.example.quickcash.models;

import java.io.Serializable;

//needs to be serializable to pass on the data from one page to another
public class Job implements Serializable {

    public static final String TAG = "Job";

    private String name;
    private String Location;
    private String TimeZone;
    private String Wage;
    private String jobOwner;
    //empty constructor for firebase
    public Job() {
    }


    //getters and setters for all the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setlocation(String location) {
        this.Location = location;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String TimeZone) {
        this.TimeZone = TimeZone;
    }
    public String getWage() {
        return Wage;
    }

    public void setWage(String wage) {this.Wage = wage;}
    public String getJobOwner() {
        return jobOwner;
    }

    public void setJobOwner(String owner) {this.jobOwner = owner;}
}