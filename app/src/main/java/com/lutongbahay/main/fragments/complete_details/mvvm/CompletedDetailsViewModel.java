package com.lutongbahay.main.fragments.complete_details.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.request.RequestAddDish;
import com.lutongbahay.rest.response.ResponseAddDish;
import com.lutongbahay.rest.service.MainService;

import okhttp3.MultipartBody;

public class CompletedDetailsViewModel extends ViewModel {
    public CompletedDetailsViewModel() {
    }

    public LiveData<ResponseAddDish> responseAddDish(Context context, RequestAddDish addDish, MultipartBody.Part file){
        return MainService.addDish(context,addDish,file);
    }
}
