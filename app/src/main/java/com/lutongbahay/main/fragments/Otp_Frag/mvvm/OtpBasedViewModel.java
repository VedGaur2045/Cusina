package com.lutongbahay.main.fragments.Otp_Frag.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseLoginUserDetail;
import com.lutongbahay.rest.response.ResponseOtpVerify;
import com.lutongbahay.rest.response.ResponseResendOtp;
import com.lutongbahay.rest.service.AuthService;
import com.lutongbahay.rest.service.MainService;
import com.lutongbahay.user_auth.activity.AuthActivity;

public class OtpBasedViewModel extends ViewModel {
    public OtpBasedViewModel() {
    }

    public LiveData<ResponseResendOtp> resendOtp(Context context, int userId){
        return AuthService.resendOtp(context,userId);
    }
    public LiveData<ResponseOtpVerify> otpVerify(Context context, int id, String otp){
        return AuthService.otpVerify(context,id,otp);
    }
    public LiveData<ResponseLoginUserDetail> loginUserDetail(String token, Context context){
        return AuthService.loginUserDetail(token,context);
    }
}
