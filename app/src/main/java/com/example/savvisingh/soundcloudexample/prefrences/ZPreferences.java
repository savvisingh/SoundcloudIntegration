package com.example.savvisingh.soundcloudexample.prefrences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Savvi on 6/22/2015.
 */
public class ZPreferences {

    private static final String KEY = "hj.prefs";
    private static final String IS_USER_LOGIN = "is_user_login";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String USER_TOKEN = "user_token";
    private static final String USER_ID = "user_id";
    private static final String DEVICE_ID = "device_id";
    private static final String IS_TUTORIAL_SHOWN = "is_show_tutorial";
    private static final String USER_REFERAL_CODE="user_referal_code";
    private static final String USER_Name = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_LAT = "user_lat";
    private static final String USER_LONG = "user_long";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_PicURL = "user_ProfilePicUrl";
    private static final String USER_DOB="user_DOB";
    private static final String AUTH_TYPE="auth_type";






    public static void setIsTutorialShown(Context context, boolean isTutorialShown) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putBoolean(IS_TUTORIAL_SHOWN, isTutorialShown);
        editor.commit();
    }

    public static boolean isTutorialShown(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getBoolean(IS_TUTORIAL_SHOWN, false);
    }

    public static void setIsUserLogin(Context context, boolean isUserSignUp) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putBoolean(IS_USER_LOGIN, isUserSignUp);
        editor.commit();
    }

    public static boolean isUserLogIn(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getBoolean(IS_USER_LOGIN, false);
    }

    public static void setUserName(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_Name, name);
        editor.commit();
    }

    public static String getUserName(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_Name, "");
    }


    public static void setAuthType(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(AUTH_TYPE, name);
        editor.commit();
    }

    public static String getAuthType(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(AUTH_TYPE, "");
    }

    public static void setUserGender(Context context, String gender) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_GENDER, gender);
        editor.commit();
    }

    public static String getUserGender(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_GENDER, "");
    }

    public static void setUserProfilePicURL(Context context, String url) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_PicURL,url);
        editor.commit();
    }

    public static String getUserProfilePicURL(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_PicURL, "");
    }

    public static void setUseremail(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_EMAIL, name);
        editor.commit();
    }

    public static String getUseremail(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_EMAIL, "");
    }
    public static void setUserToken(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_TOKEN, token);
        editor.commit();
    }

    public static String getUserToken(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_TOKEN, "");
    }

    public static void setUserLat(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_LAT, token);
        editor.commit();
    }

    public static String getUserLat(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_LAT, "");
    }

    public static void setUserLong(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_LONG, token);
        editor.commit();
    }

    public static String getUserLong(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_LONG, "");
    }



    public static void setPhoneNumber(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(PHONE_NUMBER, token);
        editor.commit();
    }

    public static String getPhoneNumber(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(PHONE_NUMBER, "");
    }

    public static void setDOB(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_DOB, token);
        editor.commit();
    }

    public static String getDOB(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_DOB, "");
    }

    public static void setUserID(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_ID, token);
        editor.commit();
    }

    public static String getUserID(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_ID, "");
    }
    public static void setReferalId(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(USER_REFERAL_CODE, token);
        editor.commit();
    }

    public static String getReferalId(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(USER_REFERAL_CODE, "");
    }

    public static void setDeviceID(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        editor.putString(DEVICE_ID, token);
        editor.commit();
    }

    public static String getDeviceID(Context context) {

        SharedPreferences savedSession = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return savedSession.getString(DEVICE_ID, "");
    }

}
