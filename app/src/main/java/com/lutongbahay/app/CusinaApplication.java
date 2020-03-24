package com.lutongbahay.app;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.helper.CheckInternetConnection;
import com.lutongbahay.helper.PreferenceManger;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class CusinaApplication extends MultiDexApplication {

    private static CusinaApplication instance;
    private static PreferenceManger preferenceManger;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/sourcesanspro_regular")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public static CusinaApplication getInstance() {
        return instance;
    }

    public static PreferenceManger getPreferenceManger() {
        if (preferenceManger == null) {
            preferenceManger = new PreferenceManger(getInstance().getSharedPreferences(PreferenceManger.PREF_KEY, Context.MODE_PRIVATE));
        }
        return preferenceManger;
    }

    public boolean isInternetConnected(Context context, boolean showDialog) {
        if (new CheckInternetConnection(this).isConnected())
            return true;
        else {
            if (showDialog) {
                CusinaAlertDialog.showDCAlertDialog(context, 0, "Network Error!!",
                        getApplicationContext().getResources().getString(R.string.no_internet_connection), null, "Ok", null, (view, dialog) -> {

                        }, null);
            }
            //  ToastUtils.longToast(R.string.no_internet_connection);
            return false;
        }
    }
}
