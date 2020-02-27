package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cusina.AdapterClass.ReviewMsgAdapterCLass.ReviewMsgAdapterClass;
import com.example.cusina.AdapterClass.ReviewMsgAdapterCLass.ReviewMsgModalClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class DishReviewsActivity extends AppCompatActivity {
    TextView titleBarTxt;
    RecyclerView reviewMsgListView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_reviews);

        UtilClass.setLightStatusBar(this,"#FFFFFF");

        setObjectId();

        titleBarTxt.setText(getString(R.string.Reviews));
        findViewById(R.id.backBtnImg).setVisibility(View.GONE);

        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getIntent().getStringExtra("ratingVal").equals("51")){
                    Intent intent = new Intent(DishReviewsActivity.this,Home.class);
                    Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(DishReviewsActivity.this, R.animator.enter_from_left, R.animator.exit_to_right).toBundle();
                    startActivity(intent,bndlAnimation);
                    finish();
                } else if(getIntent().getStringExtra("ratingVal").equals("52")){
                    Intent intent = new Intent(DishReviewsActivity.this,ViewItemActivity.class);
                    Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(DishReviewsActivity.this, R.animator.enter_from_left, R.animator.exit_to_right).toBundle();
                    startActivity(intent,bndlAnimation);
                    finish();
                }
            }
        });

        ReviewMsgModalClass[] modalClasses = new ReviewMsgModalClass[]{
                new ReviewMsgModalClass("Ved Gaur","7 minutes ago",getString(R.string._lorem_ipsum),4),
                new ReviewMsgModalClass("Deepak","8 minutes ago",getString(R.string._lorem_ipsum),3),
                new ReviewMsgModalClass("Amit Kumar","9 minutes ago",getString(R.string._lorem_ipsum),5),
                new ReviewMsgModalClass("Mitanshu","4 minutes ago",getString(R.string._lorem_ipsum),4),
                new ReviewMsgModalClass("Deepesh","4 minutes ago",getString(R.string._lorem_ipsum),2),
                new ReviewMsgModalClass("Aashish Bohra","9 minutes ago",getString(R.string._lorem_ipsum),5),
                new ReviewMsgModalClass("Ved Gaur","10 minutes ago",getString(R.string._lorem_ipsum),4),
        };

        ReviewMsgAdapterClass msgAdapterClass = new ReviewMsgAdapterClass(this,modalClasses);

        UtilClass.listFixedSize(reviewMsgListView,this);
        UtilClass.setDividerOnRecycler(reviewMsgListView,this);

        reviewMsgListView.setAdapter(msgAdapterClass);

    }

    private void setObjectId(){
        titleBarTxt = findViewById(R.id.titleName);
        reviewMsgListView = findViewById(R.id.reviewMsgListView);
    }
}
