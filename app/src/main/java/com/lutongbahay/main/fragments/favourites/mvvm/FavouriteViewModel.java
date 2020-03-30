package com.lutongbahay.main.fragments.favourites.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseSeeAllDishes;
import com.lutongbahay.rest.service.MainService;
import com.lutongbahay.utils.Constants;

public class FavouriteViewModel extends ViewModel {
    public FavouriteViewModel() {
    }

    public LiveData<ResponseSeeAllDishes> seeAllDishes(Context context, String token, double lat, double lng){
        return MainService.seeDishesList(context,token,lat,lng);
    }

}
