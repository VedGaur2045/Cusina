package com.lutongbahay.rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lutongbahay.BuildConfig;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.HostSelectionInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GooglePlacesServices {

    private static Retrofit retrofitGoogle;

    private GooglePlacesServices() {
    }

    /** Google Places API Initializations */
    public static synchronized APiInterface getGooglePlacesRetrofitInstance() {
        return initGooglePlacesRetrofit();
    }

    private static APiInterface initGooglePlacesRetrofit() {
        return getGooglePlacesAPIService();
    }

    public static APiInterface getGooglePlacesAPIService() {
        if (retrofitGoogle == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();




            retrofitGoogle = new Retrofit.Builder().baseUrl(BuildConfig.GOOGLE_PLACES_API)
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(getClient()).build();
        }
        return retrofitGoogle.create(APiInterface.class);
    }

    private static OkHttpClient getClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
        return client;
    }
}
