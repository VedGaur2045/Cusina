package com.example.cusina.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Login extends AppCompatActivity {
Button next;
ImageView close;
EditText mobile;
String mobile_number="";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  UtilClass.fullsreenui(Login.this,"#A00000");
        UtilClass.redStatusBar(this);

        requestPermission();
        next=findViewById(R.id.next);
        close=findViewById(R.id.close);
        mobile=findViewById(R.id.mobile);
        mobile_number=mobile.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobile.getText().toString().length()==0){
                    //UtilClass.showAlertDialog(Login.this,getString(R.string.alert),getString(R.string.requiredmobile));
                UtilClass.customalert(v,Login.this,getString(R.string.alert),getString(R.string.requiredmobile));
                }
                else
                {
                    if(mobile.getText().toString().length()<10) {
                        UtilClass.customalert(v,Login.this,getString(R.string.alert),getString(R.string.requiredvaildmobile));

                        //UtilClass.showAlertDialog(Login.this, getString(R.string.alert), getString(R.string.requiredvaildmobile));
                    }
                    else {
                        startPrivacyPolicyScreen();
                    }
                }



            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void startPrivacyPolicyScreen(){
        Intent intent=new Intent(Login.this, Privacy_policy.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Login.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE,ACCESS_FINE_LOCATION}, 100);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode)
            {
                case 100:{ break;}
            }

        } else {
        }
        return;


    }

}
