package com.example.cusina.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class CompletedOrdersActivity extends AppCompatActivity {

    TextView titleBartxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_orders);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        setObjectId();

        titleBartxt.setText(getString(R.string.completedOrders));
        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilClass.backbtn(CompletedOrdersActivity.this);
            }
        });

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);

    }

    private void setObjectId(){
        titleBartxt = findViewById(R.id.titleName);
    }

}
