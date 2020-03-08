package com.lutongbahay.user_auth.fragments.select_location.mvvm;

import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.user_auth.fragments.login.LoginFragmentDirections;
import com.lutongbahay.utils.SnackbarUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Abhishek Thanvi on 02/03/20.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class SelectLocationFragmentView extends FrameLayout {

    private final SelectLocationFragmentViewModel viewModel;

    public SelectLocationFragmentView(@NonNull AppCompatActivity context, SelectLocationFragmentViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_select_location, this);
        ButterKnife.bind(this, this);
    }


    @OnClick({R.id.next,R.id.close})
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.next) {
            HomeActivity.openHomeActivity(getContext());
        }else if (id == R.id.close){
            Navigation.findNavController(v).navigateUp();
        }
    }
}
