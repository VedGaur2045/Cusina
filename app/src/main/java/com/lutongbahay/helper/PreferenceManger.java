package com.lutongbahay.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.lutongbahay.rest.response.ResponseLogin;
import com.lutongbahay.rest.response.ResponseLoginUserDetails;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class PreferenceManger {

    public static final String PREF_KEY = "waiter_preference";
    public static final String AUTH_TOKEN = "auth_token";
    public static final String CURRENT_LOCATION = "current_location";
    public final String MOBILE_NUMBER = "mobile_number";

    public final String LOGIN_DETAILS = "login_details";
    public final String USER_DETAILS = "user_details";

    public final String USER_ID = "user_id";
    public final String CHECK_USER_IS_LOGGED_IN = "user_logged_in";

    private SharedPreferences mSharedPreferences;


    public PreferenceManger(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    private SharedPreferences.Editor getEditor() {
        return mSharedPreferences.edit();
    }


    public void remove(String key) {
        SharedPreferences.Editor editor = getEditor();
        editor.remove(key);
        editor.apply();
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.commit();
    }


    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getStringValue(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public String getStringValue(String key, String def) {
        return mSharedPreferences.getString(key, def);
    }

    public boolean getBooleanValue(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public boolean getBooleanValue(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public int getIntegerValue(String key) {
        return mSharedPreferences.getInt(key, 0);
    }


    public void putLastAddress(Address address) {
        Gson gson = new Gson();
        String json = gson.toJson(address);
        putString(CURRENT_LOCATION, json);
    }

    public Address getLastSavedLocation() {
        Gson gson = new Gson();
        String json = getStringValue(CURRENT_LOCATION);
        return gson.fromJson(json, Address.class);
    }

    public void putMobileNumber(String mobileNumber){
        Gson gson = new Gson();
        String json = gson.toJson(mobileNumber);
        putString(MOBILE_NUMBER,json);
    }
    public void putUserId(int userID){
        Gson gson = new Gson();
        int json = Integer.parseInt(gson.toJson(userID));
        putBoolean(CHECK_USER_IS_LOGGED_IN,true);
        putInt(USER_ID,json);
    }

    public void putLoginDetails(ResponseLogin responseLogin) {
        Gson gson = new Gson();
        String json = gson.toJson(responseLogin);
        putString(LOGIN_DETAILS, json);
    }

    public ResponseLogin getLoginDetails() {
        Gson gson = new Gson();
        String json = getStringValue(LOGIN_DETAILS);
        return gson.fromJson(json, ResponseLogin.class);
    }

    public void putUserDetails(ResponseLoginUserDetails userDetails) {
        Gson gson = new Gson();
        String json = gson.toJson(userDetails);
        putString(USER_DETAILS, json);
    }

    public ResponseLoginUserDetails getUserDetails() {
        Gson gson = new Gson();
        String json = getStringValue(USER_DETAILS);
        return gson.fromJson(json, ResponseLoginUserDetails.class);
    }


}
