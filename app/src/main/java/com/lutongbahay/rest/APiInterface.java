package com.lutongbahay.rest;


import com.lutongbahay.rest.response.BaseResponse;
import com.lutongbahay.rest.response.google_places_response.GooglePlacesAPIData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
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
    @POST("v1/auth/login_employee")
    Call<BaseResponse> loginEmployee();
}
