package com.example.quickcash.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for validating data inputs such as email, password, name, and phone number.
 */
public class DataValidator {

    // Constructor
    public DataValidator() {}

    /**
     * Checks if a string is not null.
     *
     * @param s The string to check.
     * @return true if the string is not null, false otherwise.
     */
    public static boolean notNull(String s) {
        return s != null ;
    }

    /**
     * Checks if a string is empty.
     *
     * @param s The string to check.
     * @return true if the string is empty, false otherwise.
     */
    public static  boolean isEmpty(String s){
        return s.equals("");
    }

    /**
     * Validates an email address using a regex pattern.
     *
     * @param email The email address to validate.
     * @return true if the email address is valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        // Use a simple regex pattern for email validation
        Pattern pattern = Pattern.compile(AppConstants.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * Validates a password based on a minimum length requirement.
     *
     * @param password The password to validate.
     * @return true if the password meets the minimum length requirement, false otherwise.
     */
    public static boolean isValidPassword(String password) {
        return  password.length() >= AppConstants.PASSWORD_LENGTH;
    }

    /**
     * Checks if a password matches the confirmed password.
     *
     * @param password        The password to be compared.
     * @param confirmPassword The confirmed password to compare against.
     * @return true if the passwords match, false otherwise.
     */
    public static boolean matchesConfirmPassword(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    /**
     * Validates a name using a regex pattern.
     *
     * @param name The name to validate.
     * @return true if the name is valid, false otherwise.
     */
    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }

        // Use a simple regex pattern for name validation
        Pattern pattern = Pattern.compile(AppConstants.NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    /**
     * Validates a phone number using a regex pattern.
     *
     * @param phone The phone number to be validated.
     * @return true if the phone number is valid, false otherwise.
     */
    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }

        // Use a simple regex pattern for phone validation
        Pattern pattern = Pattern.compile(AppConstants.PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }
}
