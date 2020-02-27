package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

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
        Intent intent = new Intent(Order_placed.this, Home.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Order_placed.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);
    }

    public void backBtnClick(View view) {
        UtilClass.backbtn(Order_placed.this);
    }
}
