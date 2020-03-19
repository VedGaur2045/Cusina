package com.lutongbahay.main.fragments.confirm_order;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.main.fragments.confirm_order.mvvm.ConfirmOrderView;
import com.lutongbahay.main.fragments.confirm_order.mvvm.ConfirmOrderViewModel;
import com.lutongbahay.utils.StatusBarUtils;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ConfirmOrderFragment extends Fragment {

    private ConfirmOrderView view;
    private ConfirmOrderViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.setLightStatusBar((Activity) context,"#FFFFFF");
        }
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(ConfirmOrderFragmentDirections.toDeliveryAddressFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.setLightStatusBar((Activity) context,"#FFFFFF");
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ConfirmOrderViewModel.class);
        view = new ConfirmOrderView(context,viewModel);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null && view.mapFragment != null){
            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().remove(view.mapFragment).commit();
        }
    }

}
