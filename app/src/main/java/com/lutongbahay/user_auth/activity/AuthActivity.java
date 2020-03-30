package com.lutongbahay.user_auth.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.lutongbahay.R;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.utils.StatusBarUtils;

import java.util.List;

import butterknife.ButterKnife;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class AuthActivity extends AppCompatActivity {

    public static void openAuthActivity(Context context, String otp){
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(context, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("otp",otp);
        context.startActivity(intent,bndlAnimation);
        ((AppCompatActivity)context).finish();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar(this);
        }
        ButterKnife.bind(this);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_user_auth);
        if (navHostFragment != null) {
            List<Fragment> fragmentList = navHostFragment.getChildFragmentManager().getFragments();
            for (Fragment fragment : fragmentList) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
}
