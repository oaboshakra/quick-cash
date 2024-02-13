package com.example.quickcash.util;
import com.example.quickcash.ui.Authentication.LoginActivity;
import com.example.quickcash.ui.Authentication.ApplyJobActivity;
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

    //Name and Phone.
    public static final String VALID_NAME = "Good Name";
    public static final String INVALID_NAME = "name@1234";
    public static  final String NAME_REGEX ="^([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+$";
    public static final String VALID_PHONE ="333 4444 5555" ;
    public static final String INVALID_PHONE = "123asdf";
    public static  final String PHONE_REGEX ="^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";


    // Errors message and success message
    public static final String LOGIN_SUCCESS_MESSAGE  = "Login success";
    public static final String LOGIN_FAILURE_MESSAGE  = "Login Failed / Invalid credinatials";

    public static final String INVALID_EMAIL_MESSAGE = "EMAIL_INAVLID";
    public static final String INVALID_PASSWORD_MESSAGE = "PASSWORD_INVALID";
    public static final String INVALID_PHONE_MESSAGE = "PHONE_INVALID";
    public static final String INVALID_NAME_MESSAGE = "NAME_INVALID";
    public static final String FIELD_EMPTY_MESSAGE = "Required fields cannot be empty";

    // Spinner options
    public static final String [] ROLE_SPINNER = new String[]{"Employer", "Empolyee"};


}
