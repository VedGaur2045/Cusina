package com.lutongbahay.glide;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;

import java.io.InputStream;

import okhttp3.OkHttpClient;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

@GlideModule
public class UnsafeOkHttpGlideModule extends LibraryGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpClient client = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        registry.replace(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(client));
    }
}
