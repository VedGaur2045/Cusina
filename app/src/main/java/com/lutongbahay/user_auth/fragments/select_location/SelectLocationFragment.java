package com.lutongbahay.user_auth.fragments.select_location;

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

import com.lutongbahay.user_auth.fragments.login.mvvm.LoginView;
import com.lutongbahay.user_auth.fragments.login.mvvm.LoginViewModel;
import com.lutongbahay.user_auth.fragments.select_location.mvvm.SelectLocationFragmentView;
import com.lutongbahay.user_auth.fragments.select_location.mvvm.SelectLocationFragmentViewModel;

/**
 * Created by Abhishek Thanvi on 02/03/20.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class SelectLocationFragment extends Fragment {

    private SelectLocationFragmentView view;
    private SelectLocationFragmentViewModel viewModel;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SelectLocationFragmentViewModel.class);
        view = new SelectLocationFragmentView((AppCompatActivity) context, viewModel);
        return view;
    }

}
