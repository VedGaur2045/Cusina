package com.lutongbahay.user_auth.activity.splash;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.lutongbahay.app.BaseViewModel;
import com.lutongbahay.rest.request.RequestRegisterAsMobile;
import com.lutongbahay.rest.response.ResponseRegisterAsMobile;
import com.lutongbahay.rest.service.AuthService;

public class SplashViewModel extends BaseViewModel {


    public LiveData<ResponseRegisterAsMobile> registerMobile(Context context, RequestRegisterAsMobile loginRequest) {
        return AuthService.registerMobile(context,loginRequest);
    }



    @Override
    public void onDestroy() {

    }
}
