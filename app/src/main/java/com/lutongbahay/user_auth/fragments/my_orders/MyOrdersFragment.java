package com.lutongbahay.user_auth.fragments.my_orders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.my_orders.mvvm.MyOrdersView;
import com.lutongbahay.user_auth.fragments.my_orders.mvvm.MyOrdersViewModel;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MyOrdersViewModel.class);
        view = new MyOrdersView(context,viewModel);
        return view;
    }
}
