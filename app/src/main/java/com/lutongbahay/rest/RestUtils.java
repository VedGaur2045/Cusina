package com.lutongbahay.rest;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import com.lutongbahay.BuildConfig;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class RestUtils {

    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";

    public static String getEndPoint() {
        return BuildConfig.DEBUG ? BuildConfig.STAGING_END_POINT : BuildConfig.PRODUCTION_END_POINT;
    }
}
