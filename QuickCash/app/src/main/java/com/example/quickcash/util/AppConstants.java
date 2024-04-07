package com.example.quickcash.util;
import com.example.quickcash.ui.Authentication.LoginActivity;

/**
 * This is the AppConstans class where constant variables and values which may be used all over the application are stored and called from here.
 */
public class AppConstants {

    // A constant variable for empty strings.
    public static final String EMPTY_STRING = "";

    public static final Class<LoginActivity> LAUNCHER_CLASS= LoginActivity.class;

    // Constant variables for different types of possible email and password values as well as the an email regex for proper formatting.
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

    // The following are variables being worked with in the EmployerProfile class.
    public static final String [] VALID_INDUSTRIES = new String[]{"Painting", "Cleaning", "Delivery"};
    public static final String INVALID_ID = "Invalid ID";
    public static final String [] VALID_ID = new String[]{"123456", "456123"};
    //    public static final String HIRING_STATUS = "HIRING";
    public static final String [] VALID_HIRING_STATUS = new String[]{"Yes", "No"};

    public static final String [] VALID_PHONE_NUM = new String[]{"7199209", "1231234"};

    //Name and Phone.
    public static final String VALID_NAME = "Good Name";
    public static final String INVALID_NAME = "name@1234";
    public static  final String NAME_REGEX ="^([A-ZÀ-ÿ-,a-z. ']+)+$";
    public static final String VALID_PHONE ="3334445555";
    public static final String INVALID_PHONE = "123asdf";
    public static  final String PHONE_REGEX ="^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
    public static final String INVALID_PHONE_MESSAGE = "PHONE_INVALID";
    public static final String INVALID_NAME_MESSAGE = "NAME_INVALID";

    public static final String Name = "Killer";

    public static final String Location = "park";

    public static final String wage = "12";

    public static final String TimeZOne = "3-6";

    public static final String PAYAPAL_CLIENTID = "ASLSiJD6m8KXSuLrKU6WuZ3T-vmP-ODW5hi9y-DfDzdiZAxbElKxpRzrcMJ4MEhnvJ0uy9MabB6ulRde";

    public static final double HALIFAX_LONGITUDE = -63.58;
    public static final double HALIFAX_LATITUDE = 44.65;


}
