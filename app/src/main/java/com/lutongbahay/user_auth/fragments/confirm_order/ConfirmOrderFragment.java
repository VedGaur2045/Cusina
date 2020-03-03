package com.lutongbahay.user_auth.fragments.confirm_order;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.confirm_order.mvvm.ConfirmOrderView;
import com.lutongbahay.user_auth.fragments.confirm_order.mvvm.ConfirmOrderViewModel;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ConfirmOrderViewModel.class);
        view = new ConfirmOrderView(context,viewModel);
        return view;
    }
}