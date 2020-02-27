package com.example.cusina.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import hyogeun.github.com.colorratingbarlib.ColorRatingBar;

public class PaymentMethodActivity extends AppCompatActivity {

    TextView titleBarTxt;
    RadioGroup radioGroup;
    String getTxtFromRadioBtn;
    RadioButton COD_Check,G_Cash_Check,Coins_Ph_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        setObjectId();

        titleBarTxt.setText(getString(R.string.PaymentMode));

        findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilClass.backbtn(PaymentMethodActivity.this);
            }
        });


//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (radioGroup.getId()){
//                    case R.id.COD_Checked:
//                        COD_Check.setChecked(true);
//                        G_Cash_Check.setChecked(false);
//                        Coins_Ph_check.setChecked(false);
//
//                        getTxtFromRadioBtn = "Cash on Delivery";
//
//                        break;
//                    case R.id.G_Cash_checked:
//                        COD_Check.setChecked(false);
//                        G_Cash_Check.setChecked(true);
//                        Coins_Ph_check.setChecked(false);
//
//                        getTxtFromRadioBtn = "GCash e-Wallet";
//
//                        break;
//                    case R.id.Coins_Ph_checked:
//                        COD_Check.setChecked(false);
//                        G_Cash_Check.setChecked(false);
//                        Coins_Ph_check.setChecked(true);
//
//                        getTxtFromRadioBtn = "Coins.ph e-Wallet";
//
//                        break;
//                }
//            }
//        });
    }

    private void setObjectId(){
        //radioGroup = findViewById(R.id.radioGroup);
        titleBarTxt = findViewById(R.id.titleName);
        COD_Check = findViewById(R.id.COD_Checked);
        G_Cash_Check = findViewById(R.id.G_Cash_checked);
        Coins_Ph_check = findViewById(R.id.Coins_Ph_checked);
    }

    public void BuyNowBtnOnClick(View view) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(PaymentMethodActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(new Intent(PaymentMethodActivity.this,Order_placed.class),bndlAnimation);
    }
}
