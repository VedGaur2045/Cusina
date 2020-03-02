package com.lutongbahay.app;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.lutongbahay.R;
import com.lutongbahay.helper.PreferenceManger;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;


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
                                .setDefaultFontPath("font/sourcesanspro_regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
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
