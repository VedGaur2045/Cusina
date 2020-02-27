package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class Splash extends AppCompatActivity {
EditText mobile_number;
RelativeLayout mobilenumberbox;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // UtilClass.fullsreenui(Splash.this,"#A00000");
        UtilClass.redStatusBar(this);
        mobile_number=findViewById(R.id.mobile);
        mobile_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startloginscreen();
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startloginscreen(){
        Intent intent=new Intent(Splash.this,Login.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Splash.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);
        finish();
    }
}
