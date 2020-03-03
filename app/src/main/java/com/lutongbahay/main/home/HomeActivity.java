package com.lutongbahay.main.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.activity.AuthActivity;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeActivity extends AppCompatActivity {


    public static void openHomeActivity(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
        ((AppCompatActivity)context).finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
