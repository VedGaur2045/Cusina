package com.example.lutongbahay.Activities;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import java.text.DecimalFormat;

public class ViewItemActivity extends AppCompatActivity {

    RelativeLayout minus,plus;
    TextView addToTray,productPrice,quantityProduct;
    ImageButton backBtnImg;

    double price;
    private static Integer count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.fullsreenui(this,"#A00000");
        }

        setIdOfView();

        backBtnImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(ViewItemActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(new Intent(ViewItemActivity.this, Home.class),bndlAnimation);
                finish();
            }
        });

        price = Double.parseDouble(productPrice.getText().toString());

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Integer.valueOf(quantityProduct.getText().toString())-1;

                double price = Double.parseDouble(productPrice.getText().toString());

                if(count<1)
                {
                    count = 1;
                    quantityProduct.setText(String.valueOf(count));
                    calculatePrice(count,price);
                }
                else {
                    quantityProduct.setText(String.valueOf(count));
                    calculatePrice(count,price);
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=Integer.valueOf(quantityProduct.getText().toString())+1;

                quantityProduct.setText(String.valueOf(count));
                calculatePrice(count,price);
            }
        });

    }

    private void setIdOfView(){
        minus = findViewById(R.id.minusBtn);
        plus = findViewById(R.id.plusBtn);
        backBtnImg = findViewById(R.id.backBtnImg);
        addToTray = findViewById(R.id.addToTray);
        productPrice = findViewById(R.id.productPrice);
        quantityProduct = findViewById(R.id.quantityProduct);
    }

    @SuppressLint("SetTextI18n")
    private void calculatePrice(Integer quantity, double price){
        System.out.println(price+"  "+quantity);

        double totalPrice = price * quantity;

        DecimalFormat dFormat = new DecimalFormat("#0.00");

        addToTray.setText("Add to Tray - "+dFormat.format(totalPrice));
    }

}
