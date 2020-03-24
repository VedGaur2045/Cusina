package com.lutongbahay.rest;


import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.request.RequestRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.response.ResponseRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseResendOtp;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.rest.response.google_places_response.GooglePlacesAPIData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public interface APiInterface {

    @GET("api/place/autocomplete/json")
    Call<GooglePlacesAPIData> getPlacesData(@Query("input") String type, @Query("key") String key);

    // <----- AUTH APIs START ----->
    @POST("register-mobile")
    Call<ResponseRegisterAsMobile> registerMobile(@Body RequestRegisterAsMobile registerAsMobile);

    @GET("resend-otp")
    Call<ResponseResendOtp> resendOtp(@Query("id") int page);

    @POST("seller")
    Call<ResponseAddSeller> addSeller(@Body RequestAddSeller addSeller);

    @GET("verify-kitchen")
    Call<ResponseVerifyKitchen> verifyKitchen(@Query("kitchen") String kitchenName);

    @GET("food-type")
    Call<ResponseDishCategory> dishCategory(@Header("Authorization") String token);

    @GET("payment-type")
    Call<ResponsePaymentMethod> paymentMethod(@Header("Authorization") String token);

}
