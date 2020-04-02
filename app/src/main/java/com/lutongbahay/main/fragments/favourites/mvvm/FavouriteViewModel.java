package com.lutongbahay.main.fragments.favourites.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseSeeAllDishes;
import com.lutongbahay.rest.service.MainService;

public class FavouriteViewModel extends ViewModel {
    public FavouriteViewModel() {
    }

    public LiveData<ResponseSeeAllDishes> seeAllDishesTopRated(Context context, String token, double lat, double lng){
        return MainService.seeDishesListTopRated(context,token,lat,lng);
    }
    public LiveData<ResponseSeeAllDishes> seeAllDishesScheduleMeals(Context context, String token, double lat, double lng){
        return MainService.seeDishesListScheduleMeals(context,token,lat,lng);
    }
    public LiveData<ResponseSeeAllDishes> seeAllDishesPreOrdered(Context context, String token, double lat, double lng){
        return MainService.seeDishesListPreOrdered(context,token,lat,lng);
    }
    public LiveData<ResponseSeeAllDishes> seeAllDishesNearMe(Context context, String token, double lat, double lng){
        return MainService.seeDishesListNearMe(context,token,lat,lng);
    }

}
