package com.lutongbahay.rest.service;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.APiInterface;
import com.lutongbahay.rest.request.RequestAddDish;
import com.lutongbahay.rest.request.RequestAddMenu;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.rest.response.ResponseAddDish;
import com.lutongbahay.rest.response.ResponseAddMenu;
import com.lutongbahay.rest.response.ResponseAddSeller;
import com.lutongbahay.rest.response.ResponseDishCategory;
import com.lutongbahay.rest.response.ResponseDishDetail;
import com.lutongbahay.rest.response.ResponseDocument;
import com.lutongbahay.rest.response.ResponseGetKitchenMenu;
import com.lutongbahay.rest.response.ResponseGetKitchenMenuDishes;
import com.lutongbahay.rest.response.ResponseHomeList;
import com.lutongbahay.rest.response.ResponseOtpVerify;
import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.response.ResponseSeeAllDishes;
import com.lutongbahay.rest.response.ResponseVerifyKitchen;
import com.lutongbahay.utils.Logger;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService {
    private static final APiInterface apiService =
            BaseService.getAPIClient().create(APiInterface.class);

    public MainService() {
    }

    public static LiveData<ResponseAddSeller> addSeller(final Context context, String token, RequestAddSeller requestAddSeller) {
        final MutableLiveData<ResponseAddSeller> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)) {
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseAddSeller> call = apiService.addSeller(token,requestAddSeller);
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

    public static LiveData<ResponseDocument> documentUpload(final Context context, RequestBody documentUpload, List<MultipartBody.Part> files){
        final MutableLiveData<ResponseDocument> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseDocument> call = apiService.documentUpload(documentUpload,files);
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


    public static LiveData<ResponseHomeList> homeList(final Context context, String token, double lat, double lng){
        final MutableLiveData<ResponseHomeList> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseHomeList> call = apiService.homeList(lat,lng);
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

    public static LiveData<ResponseAddDish> addDish(final Context context, RequestAddDish requestAddDish, List<MultipartBody.Part> file){
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


    public static LiveData<ResponseSeeAllDishes> seeDishesListNearMe(final Context context, String token, double Lat, double Long){
        final MutableLiveData<ResponseSeeAllDishes> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseSeeAllDishes> call = apiService.dishesListNearMe(Lat,Long);
        call.enqueue(new Callback<ResponseSeeAllDishes>() {
            @Override
            public void onResponse(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Response<ResponseSeeAllDishes> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Throwable t) {
                Logger.ErrorLog("DISHLIST API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }
    public static LiveData<ResponseSeeAllDishes> seeDishesListPreOrdered(final Context context, String token, double Lat, double Long){
        final MutableLiveData<ResponseSeeAllDishes> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseSeeAllDishes> call = apiService.dishesListPreOrdered(Lat,Long);
        call.enqueue(new Callback<ResponseSeeAllDishes>() {
            @Override
            public void onResponse(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Response<ResponseSeeAllDishes> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Throwable t) {
                Logger.ErrorLog("DISHLIST API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }
    public static LiveData<ResponseSeeAllDishes> seeDishesListTopRated(final Context context, String token, double Lat, double Long){
        final MutableLiveData<ResponseSeeAllDishes> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseSeeAllDishes> call = apiService.dishesListTopRated(Lat,Long);
        call.enqueue(new Callback<ResponseSeeAllDishes>() {
            @Override
            public void onResponse(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Response<ResponseSeeAllDishes> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Throwable t) {
                Logger.ErrorLog("DISHLIST API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }
    public static LiveData<ResponseSeeAllDishes> seeDishesListScheduleMeals(final Context context, String token, double Lat, double Long){
        final MutableLiveData<ResponseSeeAllDishes> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseSeeAllDishes> call = apiService.dishesListScheduleMeals(Lat,Long);
        call.enqueue(new Callback<ResponseSeeAllDishes>() {
            @Override
            public void onResponse(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Response<ResponseSeeAllDishes> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseSeeAllDishes> call, @NotNull Throwable t) {
                Logger.ErrorLog("DISHLIST API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }


    public static LiveData<ResponseDishDetail> dishDetail(Context context, String token, int itemId, double lng, double lat){
        final MutableLiveData<ResponseDishDetail> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseDishDetail> call = apiService.dishDetail(itemId,lat,lng);
        call.enqueue(new Callback<ResponseDishDetail>() {
            @Override
            public void onResponse(@NotNull Call<ResponseDishDetail> call, @NotNull Response<ResponseDishDetail> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseDishDetail> call, @NotNull Throwable t) {
                Logger.ErrorLog("DISHDETAILS API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseAddMenu> addMenu(Context compatActivity, RequestAddMenu addMenu){
        final MutableLiveData<ResponseAddMenu> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(compatActivity,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(compatActivity,"Please wait...");
        Call<ResponseAddMenu> addMenuCall = apiService.addMenu(addMenu);
        addMenuCall.enqueue(new Callback<ResponseAddMenu>() {
            @Override
            public void onResponse(Call<ResponseAddMenu> call, Response<ResponseAddMenu> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseAddMenu> call, Throwable t) {
                Logger.ErrorLog("ADD MENU API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseGetKitchenMenu> kitchenMenu(Context context, int kitchen_id, String token){
        final MutableLiveData<ResponseGetKitchenMenu> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseGetKitchenMenu> kitchenMenu = apiService.kitchenMenu(token,kitchen_id);
        kitchenMenu.enqueue(new Callback<ResponseGetKitchenMenu>() {
            @Override
            public void onResponse(Call<ResponseGetKitchenMenu> call, Response<ResponseGetKitchenMenu> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetKitchenMenu> call, Throwable t) {
                Logger.ErrorLog("GET KITCHEN MENU API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

    public static LiveData<ResponseGetKitchenMenuDishes> getKitchenMenuDishes(Context context, int kitchen_id, String token, double lat, double lng){
        final MutableLiveData<ResponseGetKitchenMenuDishes> data = new MutableLiveData<>();
        if(!CusinaApplication.getInstance().isInternetConnected(context,true)){
            return data;
        }
        ProgressDialogFragment.showProgressDialog(context,"Please wait...");
        Call<ResponseGetKitchenMenuDishes> kitchenMenu = apiService.getKitchenMenuDishes(kitchen_id,lat,lng);
        kitchenMenu.enqueue(new Callback<ResponseGetKitchenMenuDishes>() {
            @Override
            public void onResponse(Call<ResponseGetKitchenMenuDishes> call, Response<ResponseGetKitchenMenuDishes> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetKitchenMenuDishes> call, Throwable t) {
                Logger.ErrorLog("GET KITCHEN MENU API FAILED", t.getLocalizedMessage());
            }
        });
        return data;
    }

}
