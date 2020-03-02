package com.lutongbahay.user_auth.fragments.login;

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
import androidx.lifecycle.ViewModelProviders;

import com.lutongbahay.user_auth.fragments.login.mvvm.LoginView;
import com.lutongbahay.user_auth.fragments.login.mvvm.LoginViewModel;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class LoginFragment extends Fragment {

    private LoginView view;
    private LoginViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        view = new LoginView((AppCompatActivity) context, viewModel);
        return view;
    }
}
