package com.example.lutongbahay.Activities.SignupForms;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lutongbahay.Activities.Success_confirmation;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

public class Personal_information extends AppCompatActivity {
    Spinner genderlist,citylist;
    ImageView close;

    boolean check = false;

    EditText userName,mobileNumber,emailId,addressLine_First,addressLine_Second,userCountry,zipCode;

    final String[] gender = new String[]{"Gender", "Male", "Female", "Other"};
    final String[] countries = new String[]{"Country","Abra","Agusan del Norte","Agusan del Sur",
            "Aklan", "Albay","Antique","Bataan","Batanes","Batangas","Benguet","Bohol","Bukidnon","Bulacan",
            "Cagayan","Camarines Norte","Camarines Sur","Camiguin","Capiz","Catanduanes","Cavite","Cebu","Basilan"," Eastern Samar",
            "Davao del Sur","Davao Oriental","Ifugao","Ilocos Norte"," Ilocos Sur","Iloilo","Isabela","Laguna","Lanao del Norte","Lanao del Sur",
            "La Union","Leyte"};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        UtilClass.redStatusBar(this);

        setObjectId();

        genderlist.setPrompt("Gender");
        citylist.setPrompt("Country");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Personal_information.this, R.layout.spinner_row, R.id.item, gender);

        genderlist.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Personal_information.this, R.layout.spinner_row,R.id.item,countries);

        citylist.setAdapter(adapter2);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });
    }

    private void setObjectId(){
        genderlist = findViewById(R.id.gengerlist);
        citylist = findViewById(R.id.citylist);
        close = findViewById(R.id.close);
        userName = findViewById(R.id.username);
        mobileNumber = findViewById(R.id.usermobile);
        emailId = findViewById(R.id.useremail);
        addressLine_First = findViewById(R.id.useradddressline1);
        addressLine_Second = findViewById(R.id.useradddressline2);
        userCountry = findViewById(R.id.usercountry);
        zipCode = findViewById(R.id.zipcode);
    }

//    private boolean checkFieldObject(){
//
//    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void backToHomeBtnClick(View view) {
        //check = checkFieldObject();

        if(userName.getText().length()>0 && mobileNumber.getText().length()>0 && emailId.getText().length()>0
                && addressLine_First.getText().length()>0 && addressLine_Second.getText().length()>0 && zipCode.getText().length()>0
                && userCountry.getText().length()>0){
            Intent intent = new Intent(Personal_information.this, SignUpDocumentUploadActivity.class);
            //intent.putExtra("sellerProfileVal",11);
            Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Personal_information.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
            startActivity(intent,bndlAnimation);
            finish();
        } else {
            UtilClass.customalert(view,Personal_information.this,getString(R.string.alert),getString(R.string.fillAllField));
        }
    }



}
