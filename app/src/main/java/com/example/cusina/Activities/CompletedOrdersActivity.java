package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.cusina.AdapterClass.FragmentOrdersListAdapter.FragmentOrdersAdapterClass;
import com.example.cusina.AdapterClass.FragmentOrdersListAdapter.FragmentOrdersModalClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class CompletedOrdersActivity extends AppCompatActivity {

    TextView titleBartxt;
    Button RateServerBtn;
    RecyclerView listView;

    PopupWindow window;

    // Popup Object
    private ImageButton closeImgBtn;
    private Button submitBtn;
    private RatingBar ratingBar;
    private ViewStub viewStub;
    private TextView FastTransaction,Punctual,CustomerService,FastDelivery,Polite,Products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_orders);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        setObjectId();

        titleBartxt.setText(getString(R.string.completedOrders));
        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(CompletedOrdersActivity.this, Home.class);
//                intent.putExtra("valFromTUPage",10);
//                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(CompletedOrdersActivity.this, R.animator.enter_from_left,R.animator.exit_to_right).toBundle();
//                startActivity(intent, bndlAnimation);
                UtilClass.backbtn(CompletedOrdersActivity.this);
            }
        });

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);

        try {
            switch (getIntent().getExtras().getInt("ValCheck")){
                case 11 :
                    RateServerBtn.setVisibility(View.GONE);
                    callOrderFragmentByStatus(3);
                    break;
                case 12 :
                    RateServerBtn.setVisibility(View.VISIBLE);
                    callOrderFragmentByStatus(1);
                    break;
                case 13 :
                    RateServerBtn.setVisibility(View.GONE);
                    callOrderFragmentByStatus(2);
                    break;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

    private void callOrderFragmentByStatus(int check){
        FragmentOrdersModalClass[] ordersModalClasses = new FragmentOrdersModalClass[]{
                new FragmentOrdersModalClass(R.mipmap.fish_img_6,2,"APPLE",70.00,70.00,50.00),
                new FragmentOrdersModalClass(R.mipmap.fish_img_6,1,"BANANA",80.00,80.00,30.00),
                new FragmentOrdersModalClass(R.mipmap.fish_img_6,3,"CAT",60.00,60.00,60.00),
                new FragmentOrdersModalClass(R.mipmap.fish_img_6,2,"DAWN",80.00,80.00,50.00),
        };

        FragmentOrdersAdapterClass ordersAdapterClass = new FragmentOrdersAdapterClass(this,ordersModalClasses,check);

        UtilClass.listFixedSize(listView,this);
        UtilClass.setDividerOnRecycler(listView,this);

        listView.setAdapter(ordersAdapterClass);
    }

    private void setObjectId(){
        titleBartxt = findViewById(R.id.titleName);
        RateServerBtn = findViewById(R.id.RateServer);
        listView = findViewById(R.id.completedOrdersListItem);
    }

    private void setObjectIdOfPopUp(View popUpView){
        closeImgBtn = popUpView.findViewById(R.id.closeImgBtn);
        submitBtn = popUpView.findViewById(R.id.submitBtn);
        viewStub = popUpView.findViewById(R.id.layout_stub);
    }

    private void setViewStubObjectId(ViewStub stub){
        View inflated = stub.inflate();
        ratingBar = inflated.findViewById(R.id.ratingBarServer);
        FastTransaction = inflated.findViewById(R.id.FastTransaction);
        Punctual = inflated.findViewById(R.id.Punctual);
        CustomerService = inflated.findViewById(R.id.CustomerService);
        FastDelivery = inflated.findViewById(R.id.FastDelivery);
        Polite = inflated.findViewById(R.id.Polite);
        Products = inflated.findViewById(R.id.Products);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void rateServerBtnOnClick(View view) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.add_review_layout, null);

        setObjectIdOfPopUp(popupView);

        viewStub.setLayoutResource(R.layout.set_review_layout_for_server);

        setViewStubObjectId(viewStub);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(popupView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        assert window != null;
        //window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.show();

        closeImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompletedOrdersActivity.this, Choose_address.class) ;
                intent.putExtra("id","6");
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(CompletedOrdersActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(intent,bndlAnimation);
            }
        });

    }
}
