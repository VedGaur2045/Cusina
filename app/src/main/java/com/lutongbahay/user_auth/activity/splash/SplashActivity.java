package com.lutongbahay.user_auth.activity.splash;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;
import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.rest.request.RequestRegisterAsMobile;
import com.lutongbahay.user_auth.activity.AuthActivity;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

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

    private SplashViewModel viewModel;

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

        viewModel = ViewModelProviders.of(this).get(SplashViewModel.class);

        ButterKnife.bind(this);

        Logger.ErrorLog("Session : ",CusinaApplication.getPreferenceManger().getStringValue(CusinaApplication.getPreferenceManger().MOBILE_NUMBER));

        if(CusinaApplication.getPreferenceManger().getBooleanValue(CusinaApplication.getPreferenceManger().CHECK_USER_IS_LOGGED_IN)){
            Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
            Intent intent = new Intent(this, HomeActivity.class);
            this.startActivity(intent,bndlAnimation);
        } else {
            Logger.ErrorLog("Session : ", String.valueOf(CusinaApplication.getPreferenceManger().getIntegerValue(CusinaApplication.getPreferenceManger().USER_ID)));
        }

    }

    public static void openSplashActivity(Context context) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_left, R.animator.exit_to_right).toBundle();
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent, bndlAnimation);
        ((AppCompatActivity) context).finish();
    }


    public void registerUserMobile(AppCompatActivity context ){
        RequestRegisterAsMobile registerAsMobile = new RequestRegisterAsMobile();
        registerAsMobile.setMobile(mobileNumberEdt.getText().toString());
        viewModel.registerMobile(context, registerAsMobile).observe(context, response -> {
            if (response == null) {
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.");
            } else {
                if (!response.getSuccess()) {
                    showErrorAlert(context, response.getMessage());
                } else {
                    ToastUtils.shortToast(response.getMessage());
                    System.out.println("Otp : "+response.getData().getOtp());
                    CusinaApplication.getPreferenceManger().putUserId(response.getData().getId());
                    CusinaApplication.getPreferenceManger().putMobileNumber(mobileNumberEdt.getText().toString());
                    AuthActivity.openAuthActivity(SplashActivity.this,response.getData().getOtp());
                    (context).finish();
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
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
                registerUserMobile(SplashActivity.this);
            }
        }
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }
}
