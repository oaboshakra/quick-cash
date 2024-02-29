package com.example.quickcash.models;

import java.io.Serializable;

public class Job implements Serializable {


    public String employerEmail;
    public String jobName;
    public int hoursRequired;
    public int wage ;


    public  String skills;
    // Default constructor (required by Firebase)
    public Job() {
    }

    public Job(String employer, String jobName, int hoursRequired, int wage, String skills) {
        this.employerEmail = employer;
        this.jobName = jobName;
        this.hoursRequired = hoursRequired;
        this.wage = wage;
        this.skills = skills;
    }
    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public int getHoursRequired() {
        return hoursRequired;
    }

    public void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
