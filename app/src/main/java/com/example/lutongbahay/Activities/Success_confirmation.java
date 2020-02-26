package com.example.lutongbahay.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lutongbahay.Activities.SignupForms.Personal_information;
import com.example.lutongbahay.Fragments.Profile_Fragment;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import java.util.Objects;

public class Success_confirmation extends AppCompatActivity {
    ImageView back;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_confirmation);

        UtilClass.setLightStatusBar(this,"#ffffff");
        back=findViewById(R.id.back);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void submitAnotherApplicationBtnClick(View view) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Success_confirmation.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(new Intent(Success_confirmation.this, Personal_information.class),bndlAnimation);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void backToHomeBtnClick(View view) {
        switch (view.getId()){
            case R.id.back :
            case R.id.backToHomeBtn :
                backToHomeBtnAction();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void backToHomeBtnAction(){
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Success_confirmation.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        Intent intent = new Intent(Success_confirmation.this,Home.class);
        intent.putExtra("valFromTUPage",12);
        startActivity(intent,bndlAnimation);
        finish();

    }
}
