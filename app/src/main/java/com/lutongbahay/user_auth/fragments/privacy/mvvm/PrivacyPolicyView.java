package com.lutongbahay.user_auth.fragments.privacy.mvvm;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.activity.SplashActivity;
import com.lutongbahay.user_auth.fragments.privacy.PrivacyPolicyFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Abhishek Thanvi on 02/03/20.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class PrivacyPolicyView extends FrameLayout {

    private final PrivacyPolicyViewModel viewModel;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.close)
    ImageView close;

    public PrivacyPolicyView(@NonNull AppCompatActivity context, PrivacyPolicyViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_privacy_policy, this);
        ButterKnife.bind(this, this);
    }

    @OnClick({R.id.next,R.id.close})
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.next) {
            Navigation.findNavController(v).navigate(PrivacyPolicyFragmentDirections.toLocationFragment());
        }else if (id == R.id.close){
            SplashActivity.openSplashActivity(getContext());
        }
    }

}
