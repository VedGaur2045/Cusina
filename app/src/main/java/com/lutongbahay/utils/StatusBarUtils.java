package com.lutongbahay.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.lutongbahay.R;

/**
 * Created by Deepak Parihar on 2020-02-20.
 * Copyright © 2020 Deepak Parihar. All rights reserved.
 */

public class StatusBarUtils {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public  static  void statusBarColor(Activity context, String color){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

    public static void setLightStatusBar(Activity activity, String color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            View view = window.getDecorView();
            int flags = view.getSystemUiVisibility();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.parseColor(color));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public  static  void redStatusBar(Activity context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = context.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarTextColor(context.getResources().getColor(R.color.white));
            ActionBar actionBar = context.getActionBar();
//            actionBar.hide();
            window.setStatusBarColor(Color.parseColor("#A00000"));
        }
    }

    public static void SetStatusBarColor(Activity activity ,String statusBarColor, StatusBarState state)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(statusBarColor));
            int newUiVisibility = (int)window.getDecorView().getSystemUiVisibility();

            if (state == StatusBarState.Light)
            {
                //Dark Text to show up on your light status bar
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    newUiVisibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
            }
            else if (state == StatusBarState.Dark)
            {
                //Light Text to show up on your dark status bar
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    newUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
            }
            window.getDecorView().setSystemUiVisibility(newUiVisibility);
        }
    }

    public enum StatusBarState
    {
        Light,
        Dark
    }

}
