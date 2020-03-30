package com.lutongbahay.rest.service;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.request.RequestAddDish;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.rest.response.ResponseAddDish;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.response.ResponseDocument;
import com.lutongbahay.rest.response.ResponseHomeList;
import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.utils.Logger;

import org.jetbrains.annotations.NotNull;

import okhttp3.MultipartBody;
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
            public void onResponse(@NotNull Call<ResponseAddSeller> call, @NotNull Response<ResponseAddSeller> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseAddSeller> call, @NotNull Throwable t) {
                //show error message here
                Logger.ErrorLog("ADD SELLER API FAILED " , t.getLocalizedMessage());
            }
        });

        return data;
    }

    public static LiveData<ResponseVerifyKitchen> verifyKitchen(final Context context, String kitchenName, String token){
        final MutableLiveData<ResponseVerifyKitchen> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseVerifyKitchen> call = apiService.verifyKitchen(kitchenName, token);
        call.enqueue(new Callback<ResponseVerifyKitchen>() {
            @Override
            public void onResponse(@NotNull Call<ResponseVerifyKitchen> call, @NotNull Response<ResponseVerifyKitchen> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseVerifyKitchen> call, @NotNull Throwable t) {
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
            public void onResponse(@NotNull Call<ResponseDishCategory> call, @NotNull Response<ResponseDishCategory> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseDishCategory> call, @NotNull Throwable t) {
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
            public void onResponse(@NotNull Call<ResponsePaymentMethod> call, @NotNull Response<ResponsePaymentMethod> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponsePaymentMethod> call, @NotNull Throwable t) {
                //show error message here
                Logger.ErrorLog("DISH CATEGORY API FAILED " , t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseHomeList> homeList(final Context context, String token, String lat, String lng){
        final MutableLiveData<ResponseHomeList> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseHomeList> call = apiService.homeList("Bearer " + token,lat,lng);
        call.enqueue(new Callback<ResponseHomeList>() {
            @Override
            public void onResponse(@NotNull Call<ResponseHomeList> call, @NotNull Response<ResponseHomeList> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseHomeList> call, @NotNull Throwable t) {
                Logger.ErrorLog("HOME LIST API FAILED ", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseDocument> documentUpload(final Context context, RequestDocumentUpload documentUpload, MultipartBody.Part file1, MultipartBody.Part file2, MultipartBody.Part file3){
        final MutableLiveData<ResponseDocument> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseDocument> call = apiService.documentUpload(documentUpload,file1,file2,file3);
        call.enqueue(new Callback<ResponseDocument>() {
            @Override
            public void onResponse(@NotNull Call<ResponseDocument> call, @NotNull Response<ResponseDocument> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseDocument> call, @NotNull Throwable t) {
                Logger.ErrorLog("DOCUMENT UPLOAD API FAILED ", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseAddDish> addDish(final Context context, RequestAddDish requestAddDish,MultipartBody.Part file){
        final MutableLiveData<ResponseAddDish> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseAddDish> addDishCall = apiService.addDish(requestAddDish,file);
        addDishCall.enqueue(new Callback<ResponseAddDish>() {
            @Override
            public void onResponse(Call<ResponseAddDish> call, Response<ResponseAddDish> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseAddDish> call, Throwable t) {
                Logger.ErrorLog("ADD DISH API FAILED",t.getLocalizedMessage());
            }
        });
        return data;
    }

//    public static LiveData<ResponseDish> dish(final Context context, int itemId, String lat, String lng){
//        final MutableLiveData<ResponseDish> data = new MutableLiveData<>();
//        if (!CusinaApplication.getInstance().isInternetConnected(context,true)){
//            return data;
//        }
//        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
//        Call<ResponseDish> dishCall = apiService.dish(itemId,lat,lng);
//        dishCall.enqueue(new Callback<ResponseDish>() {
//            @Override
//            public void onResponse(Call<ResponseDish> call, Response<ResponseDish> response) {
//                if(response.body() != null){
//                    data.setValue(response.body());
//                } else {
//                    data.setValue(null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDish> call, Throwable t) {
//                Logger.ErrorLog("DISH API FAILED",t.getLocalizedMessage());
//            }
//        });
//        return data;
//    }

}
