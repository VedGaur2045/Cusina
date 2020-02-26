package com.example.lutongbahay.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import java.util.Calendar;

public class Complete_details extends AppCompatActivity {
ImageView back;
TextView toolbarTxt,dateFrom,dateTo,timeFrom,timeTo,quantity_serving,quantity_min_serving;
private int day,month,year,dayname,hour,minutes;
LinearLayout selectdate_From,selectdate_TO,selecttime_TO,selecttime_From;
RelativeLayout minus_No_of_Sell,add__No_of_Sell,minus_MinServing,add_MinServing;
Calendar mcalendar;
Button submit;
public static Integer count=1;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_details);
        UtilClass.redStatusBar(Complete_details.this);
        findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        toolbarTxt = findViewById(R.id.titleName);
        dateFrom=findViewById(R.id.dateFrom);
        dateTo=findViewById(R.id.dateTo);
        timeFrom=findViewById(R.id.timefrom);
        timeTo=findViewById(R.id.timeto);
        selectdate_From=findViewById(R.id.selectdatefrom);
        selectdate_TO=findViewById(R.id.selectdateto);
        selecttime_From=findViewById(R.id.selecttimefrom);
        selecttime_TO=findViewById(R.id.selecttimeto);
        minus_No_of_Sell=findViewById(R.id.minus_No_of_Sell);
        add__No_of_Sell=findViewById(R.id.add_No_of_Sell);
        minus_MinServing=findViewById(R.id.minus_MinServing);
        add_MinServing=findViewById(R.id.add_MinServing);
        quantity_serving=findViewById(R.id.quantity);
        quantity_min_serving=findViewById(R.id.quantity2);
        submit=findViewById(R.id.submit);
         mcalendar = Calendar.getInstance();
         day=mcalendar.get(Calendar.DAY_OF_MONTH);
        year=mcalendar.get(Calendar.YEAR);
        month=mcalendar.get(Calendar.MONTH);
        dayname=mcalendar.get(Calendar.DAY_OF_WEEK);
        hour = mcalendar.get(Calendar.HOUR_OF_DAY);
        minutes = mcalendar.get(Calendar.MINUTE);
        dateFrom.setText(UtilClass.getCurrentdate());
        dateTo.setText(UtilClass.getTomorrowdate());
        //timeFrom.setText(UtilClass.getCurrentTime());
        toolbarTxt.setText(getString(R.string.complete_dish_details));
        findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UtilClass.backbtn(Complete_details.this);
            }
        });
        selectdate_From.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UtilClass.DateDialog(Complete_details.this,day,month,year,dateFrom);

            }
        });
        selectdate_TO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.DateDialog(Complete_details.this,day,month,year,dateTo);
            }
        });
        selecttime_From.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.TimeDialog(Complete_details.this,hour,minutes,timeFrom);
            }
        });
        selecttime_TO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.TimeDialog(Complete_details.this,hour,minutes,timeTo);
            }
        });
        minus_No_of_Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UtilClass.counterminus(quantity_serving);
            }
        });
        add__No_of_Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.counterplus(quantity_serving);
            }
        });
        minus_MinServing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.counterminus(quantity_min_serving);
            }
        });
        add_MinServing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilClass.counterplus(quantity_min_serving);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dishlisted();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void dishlisted(){
        Intent intent=new Intent(Complete_details.this, Success_confirmation.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Complete_details.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);

    }
}
