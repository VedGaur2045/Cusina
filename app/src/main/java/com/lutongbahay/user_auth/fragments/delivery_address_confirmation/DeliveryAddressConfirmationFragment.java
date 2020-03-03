package com.lutongbahay.user_auth.fragments.delivery_address_confirmation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lutongbahay.user_auth.fragments.delivery_address_confirmation.mvvm.DeliveryAddressView;
import com.lutongbahay.user_auth.fragments.delivery_address_confirmation.mvvm.DeliveryAddressViewModel;


/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class DeliveryAddressConfirmationFragment extends Fragment {

    private DeliveryAddressView view;
    private DeliveryAddressViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(DeliveryAddressViewModel.class);
        view = new DeliveryAddressView((AppCompatActivity) context,viewModel);
        return view;
    }
}
