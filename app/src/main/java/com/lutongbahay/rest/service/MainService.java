package com.lutongbahay.rest.service;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService {
    private static final APiInterface apiService =
            BaseService.getAPIClient().create(APiInterface.class);

    public MainService() {
    }

    public static LiveData<ResponseAddSeller> addSeller(final Context context, RequestAddSeller requestAddSeller) {
        final MutableLiveData<ResponseAddSeller> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)) {
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseAddSeller> call = apiService.addSeller(requestAddSeller);
        call.enqueue(new Callback<ResponseAddSeller>() {
            @Override
            public void onResponse(Call<ResponseAddSeller> call, Response<ResponseAddSeller> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseAddSeller> call, Throwable t) {
                //show error message here
                Logger.ErrorLog("ADD SELLER API FAILED " , t.getLocalizedMessage());
            }
        });

        return data;
    }

    public static LiveData<ResponseVerifyKitchen> verifyKitchen(final Context context, String kitchenName){
        final MutableLiveData<ResponseVerifyKitchen> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseVerifyKitchen> call = apiService.verifyKitchen(kitchenName);
        call.enqueue(new Callback<ResponseVerifyKitchen>() {
            @Override
            public void onResponse(Call<ResponseVerifyKitchen> call, Response<ResponseVerifyKitchen> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseVerifyKitchen> call, Throwable t) {
                //show error message here
                Logger.ErrorLog("DISH CATEGORY API FAILED " , t.getLocalizedMessage());
            }
        });

        return data;
    }

    public static LiveData<ResponseDishCategory> dishCategory(final Context context, String token){
        final MutableLiveData<ResponseDishCategory> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseDishCategory> call = apiService.dishCategory("Bearer " + token);
        call.enqueue(new Callback<ResponseDishCategory>() {
            @Override
            public void onResponse(Call<ResponseDishCategory> call, Response<ResponseDishCategory> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseDishCategory> call, Throwable t) {
                //show error message here
                Logger.ErrorLog("DISH CATEGORY API FAILED " , t.getLocalizedMessage());
            }
        });

        return data;
    }

    public static LiveData<ResponsePaymentMethod> paymentMethod(final Context context, String token){
        final MutableLiveData<ResponsePaymentMethod> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponsePaymentMethod> call = apiService.paymentMethod("Bearer " + token);
        call.enqueue(new Callback<ResponsePaymentMethod>() {
            @Override
            public void onResponse(Call<ResponsePaymentMethod> call, Response<ResponsePaymentMethod> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponsePaymentMethod> call, Throwable t) {
                //show error message here
                Logger.ErrorLog("DISH CATEGORY API FAILED " , t.getLocalizedMessage());
            }
        });
        return data;
    }

}
