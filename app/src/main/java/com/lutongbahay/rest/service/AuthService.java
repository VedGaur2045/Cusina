package com.lutongbahay.rest.service;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.request.RequestRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseLoginUserDetail;
import com.lutongbahay.rest.response.ResponseOtpVerify;
import com.lutongbahay.rest.response.ResponseRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseResendOtp;
import com.lutongbahay.utils.Logger;

import org.jetbrains.annotations.NotNull;

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

    public static LiveData<ResponseResendOtp> resendOtp(final Context context, int userId){
        final MutableLiveData<ResponseResendOtp> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseResendOtp> call = apiService.resendOtp(userId);
        call.enqueue(new Callback<ResponseResendOtp>() {
            @Override
            public void onResponse(@NotNull Call<ResponseResendOtp> call, @NotNull Response<ResponseResendOtp> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseResendOtp> call, @NotNull Throwable t) {
                //show error message here
                Logger.ErrorLog("RESEND OTP API FAILED " , t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseOtpVerify> otpVerify(Context context, int id, String otp){
        final MutableLiveData<ResponseOtpVerify> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseOtpVerify> otpVerify = apiService.otpVerify(id, otp);
        otpVerify.enqueue(new Callback<ResponseOtpVerify>() {
            @Override
            public void onResponse(Call<ResponseOtpVerify> call, Response<ResponseOtpVerify> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseOtpVerify> call, Throwable t) {
                Logger.ErrorLog("OTP VERIFY API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseLoginUserDetail> loginUserDetail(String token, Context context){
        final MutableLiveData<ResponseLoginUserDetail> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseLoginUserDetail> call = apiService.loginUserDetail("Bearer "+token);
        call.enqueue(new Callback<ResponseLoginUserDetail>() {
            @Override
            public void onResponse(Call<ResponseLoginUserDetail> call, Response<ResponseLoginUserDetail> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseLoginUserDetail> call, Throwable t) {
                Logger.ErrorLog("LOGIN USER DETAIL API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

}
