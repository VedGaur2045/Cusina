package com.lutongbahay.main.fragments.my_orders_frag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.main.fragments.my_orders_frag.mvvm.MyOrdersView;
import com.lutongbahay.main.fragments.my_orders_frag.mvvm.MyOrdersViewModel;

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
        if (view == null){
            view = new MyOrdersView(context,viewModel);
        }
        return view;
    }
}
