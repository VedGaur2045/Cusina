package com.lutongbahay.user_auth.fragments.login.mvvm;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;
import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.login.LoginFragmentDirections;
import com.lutongbahay.utils.SnackbarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class LoginView extends FrameLayout {

    private final LoginViewModel viewModel;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.close)
    ImageView close;
    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.countryCodeHolder)
    CountryCodePicker countryCodeHolder;
    @BindView(R.id.mobilenumberbox)
    RelativeLayout mobilenumberbox;

    public LoginView(@NonNull AppCompatActivity context, LoginViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_login, this);
        ButterKnife.bind(this, this);
    }

    @OnClick({R.id.next,R.id.close})
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.next) {
            if (android.text.TextUtils.isEmpty(mobile.getText().toString()) || mobile.getText().toString().length() < 10) {
                SnackbarUtils.showSnackBar(v, "Please enter a valid mobile number", Snackbar.LENGTH_LONG);
            }else{
                Navigation.findNavController(v).navigate(LoginFragmentDirections.toPrivacyFragment());
            }
        }else if (id == R.id.close){
            ((AppCompatActivity)getContext()).finish();
            ((AppCompatActivity)getContext()).overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
        }
    }
}
