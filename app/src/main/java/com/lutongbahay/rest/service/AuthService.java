package com.lutongbahay.rest.service;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.request.register_as_mobile.RequestRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseRegisterAsMobile;
import com.lutongbahay.utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class AuthService {

    private static final APiInterface apiService =
            BaseService.getAPIClient().create(APiInterface.class);

    public AuthService() {
    }

    public static LiveData<ResponseRegisterAsMobile> registerMobile(final Context context, RequestRegisterAsMobile requestRegisterAsMobile) {
        final MutableLiveData<ResponseRegisterAsMobile> data = new MutableLiveData<>();
        if (!CusinaApplication.getInstance().isInternetConnected(context, true)) {
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context, "Please wait...");

        Call<ResponseRegisterAsMobile> call = apiService.registerMobile(requestRegisterAsMobile);
        call.enqueue(new Callback<ResponseRegisterAsMobile>() {
            @Override
            public void onResponse(@NonNull Call<ResponseRegisterAsMobile> call, @NonNull Response<ResponseRegisterAsMobile> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseRegisterAsMobile> call, @NonNull Throwable t) {
                //show error message here
                Logger.ErrorLog("REGISTER MOBILE API FAILED " , t.getLocalizedMessage());
            }
        });
        return data;
    }



}
