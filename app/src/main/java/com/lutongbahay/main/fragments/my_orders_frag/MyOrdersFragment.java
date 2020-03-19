package com.lutongbahay.main.fragments.my_orders_frag;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.main.fragments.my_orders_frag.mvvm.MyOrdersView;
import com.lutongbahay.main.fragments.my_orders_frag.mvvm.MyOrdersViewModel;
import com.lutongbahay.utils.StatusBarUtils;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class MyOrdersFragment extends Fragment {

    private MyOrdersViewModel viewModel;
    private MyOrdersView view;
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
                Navigation.findNavController(view).navigate(MyOrdersFragmentDirections.toHomeFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MyOrdersViewModel.class);
        if (view == null){
            view = new MyOrdersView(context,viewModel,getChildFragmentManager());
        }


        return view;
    }
}
