package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class Privacy_policy extends AppCompatActivity {
    Button next;
    ImageView close;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        UtilClass.redStatusBar(this);
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startloginscreen();
            }
        });
        close=findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void startloginscreen(){
        Intent intent=new Intent(Privacy_policy.this, Choose_address.class);
        intent.putExtra("id",1);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);

    }

}
