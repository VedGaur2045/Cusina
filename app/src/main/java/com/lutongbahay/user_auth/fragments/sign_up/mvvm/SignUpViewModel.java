package com.lutongbahay.user_auth.fragments.sign_up.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.rest.service.MainService;

public class SignUpViewModel extends ViewModel {
    public SignUpViewModel() {
    }
    public LiveData<ResponseAddSeller> addSeller(Context context, RequestAddSeller addSeller){
        return MainService.addSeller(context,addSeller);
    }
    public LiveData<ResponseVerifyKitchen> verifyKitchen(Context context, String kitchenName,String token){
        return MainService.verifyKitchen(context,kitchenName,token);
    }
}
