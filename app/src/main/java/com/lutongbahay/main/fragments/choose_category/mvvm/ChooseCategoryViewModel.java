package com.lutongbahay.main.fragments.choose_category.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.service.MainService;

public class ChooseCategoryViewModel extends ViewModel {
    public ChooseCategoryViewModel() {
    }

    public LiveData<ResponseDishCategory> dishCategory(Context context,String token){
        return MainService.dishCategory(context, token);
    }

}
