package com.example.quickcash.util;
import com.example.quickcash.ui.Authentication.LoginActivity;

public class AppConstants {
    public static final String EMPTY_STRING = "";

    public static final Class<LoginActivity> LAUNCHER_CLASS= LoginActivity.class;


     // Email and password.
    public static final String INVALID_EMAIL = "inavlid1004";
    public static final String VALID_EMAIL = "nith2411@gmail.com";

    public static final String VALID_PASSWORD ="Nithish24" ;
    public static final String INVALID_PASSWORD = "123";
    public static  final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final int PASSWORD_LENGTH = 8;



    // Errors message and success message
    public static final String LOGIN_SUCCESS_MESSAGE  = "Login success";
    public static final String LOGIN_FAILURE_MESSAGE  = "Login Failed / Invalid credinatials";

    public static final String INVALID_EMAIL_MESSAGE = "EMAIL_INAVLID";
    public static final String INVALID_PASSWORD_MESSAGE = "PASSWORD_INVALID";
    public static final String FIELD_EMPTY_MESSAGE = "Required fields cannot be empty";

    // Spinner options
    public static final String [] ROLE_SPINNER = new String[]{"Employer", "Empolyee"};

    public static final String INVALID_TIMEZONEWAGE = "Choose time zone and wage";

    public static final String INVALID_TIMEZONE = "Choose time zone";

    public static final String INVALID_WAGE = "Choose wage";

    //-------

    public static final String [] VALID_INDUSTRIES = new String[]{"Painting", "Cleaning", "Delivery"};
    public static final String INVALID_ID = "Invalid ID";
    public static final String [] VALID_ID = new String[]{"123456", "456123"};
    //    public static final String HIRING_STATUS = "HIRING";
    public static final String [] VALID_HIRING_STATUS = new String[]{"Yes", "No"};

    public static final String [] VALID_PHONE_NUM = new String[]{"7199209", "1231234"};

}
