package com.example.cusina.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cusina.AdapterClass.ConfirmOrderAdapter.ConfirmOrderAdapter;
import com.example.cusina.AdapterClass.ConfirmOrderAdapter.ConfirmOrderModel;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class ConfirmOrderActivity extends AppCompatActivity {

    TextView titleBarTxt,MyAddressTxt,changeAddress;
    LinearLayout customerAddressLayout;
    ImageView changeAddressPencilBtnSecond;

    RecyclerView order_list_item_vertical;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        setObjectId();

        titleBarTxt = findViewById(R.id.titleName);
        titleBarTxt.setText(getString(R.string.confirmOrder));

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);

        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilClass.backbtn(ConfirmOrderActivity.this);
                finish();
            }
        });

        changeAddressPencilBtnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmOrderActivity.this, Choose_address.class) ;
                intent.putExtra("id","9");
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(ConfirmOrderActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(intent,bndlAnimation);
            }
        });

        order_list_item_vertical.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        ConfirmOrderModel[] ordersHolderClasses = new ConfirmOrderModel[]{
                new ConfirmOrderModel("ABC",50.00,70.00,70.00,2),
                new ConfirmOrderModel("DEF",40.00,80.00,80.00,1),
        };

        ConfirmOrderAdapter ordersAdapterClass = new ConfirmOrderAdapter(ordersHolderClasses,this);

        listFixedSize(order_list_item_vertical);

        order_list_item_vertical.setAdapter(ordersAdapterClass);

    }

    private void setObjectId(){
        MyAddressTxt = findViewById(R.id.MyAddressTxt);
        changeAddress = findViewById(R.id.changeAddress);
        customerAddressLayout = findViewById(R.id.customerAddressLayout);
        order_list_item_vertical = findViewById(R.id.order_list_item_vertical);
        changeAddressPencilBtnSecond = findViewById(R.id.changeAddressPencilBtn);
    }

    private void listFixedSize(RecyclerView itemList){
        itemList.setHasFixedSize(true);
        itemList.setLayoutManager(new LinearLayoutManager(this));
    }

    public void buyNowBtnOnClick(View view) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(ConfirmOrderActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(new Intent(ConfirmOrderActivity.this,PaymentMethodActivity.class),bndlAnimation);
    }
}
