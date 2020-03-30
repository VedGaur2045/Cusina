package com.lutongbahay.main.fragments.home_frag.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseHomeList;
import com.lutongbahay.rest.service.MainService;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class HomeFragViewModel extends ViewModel {
    public HomeFragViewModel() {
    }

    public LiveData<ResponseHomeList> homeList(Context context, String token, String lat, String lng){
        return MainService.homeList(context,token,lat,lng);
    }

}
