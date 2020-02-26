package com.example.lutongbahay.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import org.w3c.dom.Text;

public class delivery_address_confirmation extends AppCompatActivity {

    EditText userName,userEmail,userAddress;
    Button saveDetail;
    TextView titleBarTxt;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address_confirmation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        titleBarTxt = findViewById(R.id.titleName);
        titleBarTxt.setText(getString(R.string.myDetails));
        findViewById(R.id.backBtnImg).setVisibility(View.GONE);

        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(delivery_address_confirmation.this, R.animator.enter_from_left, R.animator.exit_to_right).toBundle();
                startActivity(new Intent(delivery_address_confirmation.this,MyTrayActivity.class),bndlAnimation);
            }
        });

        setObjectId();
    }

    private void setObjectId(){
        userName = findViewById(R.id.username);
        userEmail = findViewById(R.id.userEmailId);
        userAddress = findViewById(R.id.addressTxt);
        saveDetail = findViewById(R.id.saveDetails);
    }

    public void saveDetailsBtnOnClick(View view) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(delivery_address_confirmation.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(new Intent(delivery_address_confirmation.this,ConfirmOrderActivity.class),bndlAnimation);
    }
}
