package com.example.lutongbahay.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

public class Order_placed extends AppCompatActivity {
    ImageView back;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        UtilClass.setLightStatusBar(this,"#F6F6F6");

    }

    public void backToFoodMenuOnClick(View view) {
        UtilClass.backbtn(Order_placed.this);
    }

    public void backBtnClick(View view) {
        UtilClass.backbtn(Order_placed.this);
    }
}
