package com.lutongbahay.main.fragments.payment_method;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.payment_method.mvvm.PaymentMethodView;
import com.lutongbahay.main.fragments.payment_method.mvvm.PaymentMethodViewModel;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */
public class PaymentMethodFragment extends Fragment {

    private PaymentMethodView view;
    private PaymentMethodViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(PaymentMethodViewModel.class);
        view = new PaymentMethodView(context,viewModel);
        return view;
    }
}
