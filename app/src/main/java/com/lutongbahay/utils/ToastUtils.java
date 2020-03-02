package com.lutongbahay.utils;


import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.annotation.StringRes;

import com.lutongbahay.app.CusinaApplication;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */


public class ToastUtils {

    public static void shortToast(@StringRes int text) {
        shortToast(CusinaApplication.getInstance().getString(text));
    }

    public static void shortToast(String text) {
        if (TextUtils.isEmpty(text))
            return;
        show(text, Toast.LENGTH_SHORT);
    }

    public static void longToast(@StringRes int text) {
        longToast(CusinaApplication.getInstance().getString(text));
    }

    public static void longToast(String text) {
        if (TextUtils.isEmpty(text))
            return;
        show(text, Toast.LENGTH_LONG);
    }

    private static Toast makeToast(String text, @ToastLength int length) {
        return Toast.makeText(CusinaApplication.getInstance(), text, length);
    }

    private static void show(String text, @ToastLength int length) {
        makeToast(text, length).show();
    }

    @IntDef({Toast.LENGTH_LONG, Toast.LENGTH_SHORT})
    private @interface ToastLength {

    }
}