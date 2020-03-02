package com.lutongbahay.rest;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public final class HostSelectionInterceptor implements Interceptor {
    private String host;
    private String scheme;

    private static HostSelectionInterceptor selectionInterceptor = null;

    private HostSelectionInterceptor() {
        //Intentionally left blank
    }

    public static HostSelectionInterceptor getSelectionInterceptor() {
        if (selectionInterceptor==null){
            selectionInterceptor= new HostSelectionInterceptor();
        }
        return selectionInterceptor;
    }

    public void setInterceptor(String url) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl != null) {
            scheme = httpUrl.scheme();
            host = httpUrl.host();
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        // If new Base URL is properly formatted then replace the old one
        if (scheme != null && host != null) {
            HttpUrl newUrl = original.url().newBuilder()
                    .scheme(scheme)
                    .host(host)
                    .build();
            original = original.newBuilder()
                    .url(newUrl)
                    .build();
        }
        return chain.proceed(original);
    }
}
