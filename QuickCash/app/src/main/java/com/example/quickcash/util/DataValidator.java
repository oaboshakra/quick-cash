package com.example.quickcash.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public DataValidator() {}

    public static boolean notNull(String s) {
        return s != null ;
    }
    public static  boolean isEmpty(String s){
        return s.equals("");
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        // Use a simple regex pattern for email validation
        Pattern pattern = Pattern.compile(AppConstants.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        return  password.length() >= AppConstants.PASSWORD_LENGTH;
    }

    public static boolean matchesConfirmPassword(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }

        // Use a simple regex pattern for name validation
        Pattern pattern = Pattern.compile(AppConstants.NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

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
