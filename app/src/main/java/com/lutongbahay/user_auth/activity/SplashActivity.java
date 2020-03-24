package com.lutongbahay.user_auth.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;
import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.AppAction;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.user_auth.fragments.login.LoginFragmentDirections;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.StatusBarUtils;

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
    @BindView(R.id.countryCodeHolder)
    CountryCodePicker countryCodeHolder;
    @BindView(R.id.skipFroNowId)
    TextView skipFroNowId;
    @BindView(R.id.nextImageBtn)
    ImageButton nextImageBtn;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar(this);
        }
        ButterKnife.bind(this);
    }

    public static void openSplashActivity(Context context) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_left, R.animator.exit_to_right).toBundle();
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent, bndlAnimation);
        ((AppCompatActivity) context).finish();
    }

    @OnClick({R.id.skipFroNowId,R.id.nextImageBtn})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.skipFroNowId) {
//            HomeActivity.openHomeActivity(SplashActivity.this);
            Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
            Intent intent = new Intent(this, HomeActivity.class);
            this.startActivity(intent,bndlAnimation);
        } else if(id == R.id.nextImageBtn){
            if(android.text.TextUtils.isEmpty(mobileNumberEdt.getText().toString()) || mobileNumberEdt.getText().toString().length() < 10 && countryCodeHolder.getSelectedCountryCode().isEmpty()){
                SnackbarUtils.showSnackBar(view, "Please enter a valid mobile number", Snackbar.LENGTH_LONG);
            }else{
                String mobile = countryCodeHolder.getSelectedCountryCodeWithPlus().toString()+""+mobileNumberEdt.getText().toString();
                System.out.println(mobile);
                CusinaApplication.getPreferenceManger().putMobileNumber(mobile);
                AuthActivity.openAuthActivity(SplashActivity.this);
            }
        }
    }
}
