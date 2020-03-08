package com.lutongbahay.app;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.lutongbahay.R;
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
                                .setDefaultFontPath("fonts/sourcesanspro_regular.otf")
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
}
