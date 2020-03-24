package com.lutongbahay.main.fragments.payment_method.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.response.ResponsePaymentMethod;
import com.lutongbahay.rest.service.MainService;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class PaymentMethodViewModel extends ViewModel {
    public PaymentMethodViewModel() {
    }

    public LiveData<ResponsePaymentMethod> paymentMethod(Context context,String token){
        return MainService.paymentMethod(context, token);
    }

}
