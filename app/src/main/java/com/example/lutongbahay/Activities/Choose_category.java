package com.example.lutongbahay.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutongbahay.AdapterClass.ChooseCategoryAdapter.ChooseCategory_adapter;
import com.example.lutongbahay.AdapterClass.ChooseCategoryAdapter.ChooseCategory_datamodel;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import java.util.ArrayList;

public class Choose_category extends AppCompatActivity {
ImageView back;
ListView listView;
TextView toolbarTxt;
ArrayList<ChooseCategory_datamodel> model=new ArrayList<>();
ChooseCategory_adapter chooseCategory_adapter;
String category_name[]=new String[]{"Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum","Lorem Ipsum"};
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        UtilClass.redStatusBar(Choose_category.this);
        listView=findViewById(R.id.listview);
        findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        toolbarTxt = findViewById(R.id.titleName);
        toolbarTxt.setText(getString(R.string.choose_category));

        for(int i=0;i<category_name.length;i++){
            ChooseCategory_datamodel chooseCategory_datamodel=new ChooseCategory_datamodel(category_name[i]);
            model.add(chooseCategory_datamodel);
        }
        chooseCategory_adapter=new ChooseCategory_adapter(model, Choose_category.this);
        listView.setAdapter(chooseCategory_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            completedetails();
            }
        });
        findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.enter_from_left, R.animator.exit_to_right);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void completedetails(){
        Intent intent=new Intent(Choose_category.this, Complete_details.class);
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(Choose_category.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(intent, bndlAnimation);

    }
}
