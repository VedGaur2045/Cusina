package com.lutongbahay.rest;


import com.lutongbahay.rest.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public interface APiInterface {

    // <----- AUTH APIs START ----->
    @POST("v1/auth/login_employee")
    Call<BaseResponse> loginEmployee();
}
