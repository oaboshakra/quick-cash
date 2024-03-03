package com.example.quickcash.models;

import java.io.Serializable;

public class User implements Serializable {

    private String FirstName ;
    private String LastName ;
    private String email ;
    private String password;
    private String role;


    public User(){}
    public User(String firstName, String lastName, String email, String password, String role) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.email = email;
        this.role = role;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
