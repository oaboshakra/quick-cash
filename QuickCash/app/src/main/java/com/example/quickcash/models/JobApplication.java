package com.example.quickcash.models;
import java.io.Serializable;
//needs to be serializable to pass on the data from one page to another
public class JobApplication implements Serializable{
    public static final String TAG = "JobApplication";

    private String jobName;
    private String employeeName;
    private String employeePhone;
    private String employeeEmail;
    private String status;
    //empty constructor for firebase
    public JobApplication() {
    }

    public String getJobName() {
        return jobName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
