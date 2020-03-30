package com.lutongbahay.main.fragments.item_detail.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseDishDetail;
import com.lutongbahay.rest.service.MainService;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ItemDetailViewModel extends ViewModel {
    public ItemDetailViewModel() {
    }

    public LiveData<ResponseDishDetail> dishDetail(Context context,int itemId , String token, double lng, double lat){
        return MainService.dishDetail(context,token,itemId,lng,lat);
    }

}
