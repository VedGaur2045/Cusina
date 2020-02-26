package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cusina.Activities.SignupForms.Personal_information;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class SellFoodWithLutongBahayActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_food_with_lutong_bahay);
        UtilClass.redStatusBar(this);

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);
        findViewById(R.id.closeImgBtn).setVisibility(View.VISIBLE);
        TextView toolBarTitleTxt = findViewById(R.id.titleName);
        toolBarTitleTxt.setText(getString(R.string.SellwithLutongBahay));

        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });

        findViewById(R.id.signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(SellFoodWithLutongBahayActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(new Intent(SellFoodWithLutongBahayActivity.this, Personal_information.class),bndlAnimation );
            }
        });

    }
}
