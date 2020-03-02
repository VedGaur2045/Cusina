package com.lutongbahay.user_auth.fragments.select_location.mvvm;

import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.lutongbahay.R;

import butterknife.ButterKnife;

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
}
