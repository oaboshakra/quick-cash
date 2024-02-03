package com.example.quickcash.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.example.quickcash.ui.Authentication.LoginActivity;

public class AppConstants {

    public static  final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final int PASSWORD_LENGTH = 8;

    public static final Class<LoginActivity> LAUNCHER_CLASS= LoginActivity.class;

    public static final String INVALID_EMAIL = "inavlid1004";
    public static final String VALID_EMAIL = "nith2411@gmail.com";

    public static final String VALID_PASSWORD ="abcdefgh" ;
    public static final String INVALID_PASSWORD = "123";
    public static final String INVALID_EMAIL_ERROR = "EMAIL_INAVLID" ;
    public static final String INVALID_PASSWORD_ERROR = "PASSWORD_INVALID";

    public static final String EMPTY_STRING = "";
    public static final String FIELD_EMPTY_ERROR = "Required fields cannot be empty";
}
