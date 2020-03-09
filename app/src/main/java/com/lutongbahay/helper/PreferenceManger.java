package com.lutongbahay.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class PreferenceManger {

    public static final String PREF_KEY = "waiter_preference";
    public static final String AUTH_TOKEN = "auth_token";
    public static final String CURRENT_LOCATION = "current_location";

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



}
