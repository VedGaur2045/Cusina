package com.lutongbahay.user_auth.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.mobile)
    EditText mobileNumberEdt;
    @BindView(R.id.mobilenumberbox)
    RelativeLayout mobileBottomLayout;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mobile, R.id.mobilenumberbox})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.mobile) {
            AuthActivity.openAuthActivity(SplashActivity.this);
        } else if (id == R.id.mobilenumberbox) {

        }
    }

    public void openLogin(){

    }
}
