package com.lutongbahay.rest;


import com.lutongbahay.rest.request.RequestAddDish;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.rest.request.RequestRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseAddDish;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.response.ResponseDishDetail;
import com.lutongbahay.rest.response.ResponseDocument;
import com.lutongbahay.rest.response.ResponseHomeList;
import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.response.ResponseRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseResendOtp;
import com.lutongbahay.rest.response.ResponseSeeAllDishes;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.rest.response.google_places_response.GooglePlacesAPIData;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
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

    @GET("resend-otp/{id}")
    Call<ResponseResendOtp> resendOtp(@Path("id") int page);

    @Headers("Cache-control: no-cache")
    @POST("seller")
    Call<ResponseAddSeller> addSeller(@Body RequestAddSeller addSeller);

    @GET("verify-kitchen/{kitchen}")
    Call<ResponseVerifyKitchen> verifyKitchen(@Header("Authorization") String token, @Path("kitchen") String kitchenName);

    @GET("food-type")
    Call<ResponseDishCategory> dishCategory(@Header("Authorization") String token);

    @GET("payment-type")
    Call<ResponsePaymentMethod> paymentMethod(@Header("Authorization") String token);

    @GET("dishes")
    Call<ResponseHomeList> homeList(@Header("Authorization") String token, @Query("lat") double lat, @Query("long") double lng);

    @Multipart
    @POST("document")
    Call<ResponseDocument> documentUpload(@Body RequestDocumentUpload documentUpload,@Part MultipartBody.Part file1,@Part MultipartBody.Part file2,@Part MultipartBody.Part file3);

    @Multipart
    @POST("dish")
    Call<ResponseAddDish> addDish(@Body RequestAddDish addDish,@Part MultipartBody.Part file1);

    @GET("see-all/{}")
    Call<ResponseSeeAllDishes> dishesList(@Header("Authorization") String token, @Query("lat") double lat, @Query("long") double lng);

    @GET("dish/{id}")
    Call<ResponseDishDetail> dishDetail(@Header("Authorization") String token, @Path("id") int itemId, @Query("lng") double lat, @Query("long") double lng);

//    @GET("dish/{id}")
//    Call<ResponseDish> dish(@Path("id") int itemId,@Query("lng") String lat, @Query("long") String lng);

}
