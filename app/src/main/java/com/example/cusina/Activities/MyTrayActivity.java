package com.example.cusina.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.AdapterClass.ConfirmOrderAdapter.ConfirmOrderAdapter;
import com.example.cusina.AdapterClass.ConfirmOrderAdapter.ConfirmOrderModel;
import com.example.cusina.AdapterClass.ordersMyTrayRecyclerListAdapter.ordersAdapterClass;
import com.example.cusina.AdapterClass.ordersMyTrayRecyclerListAdapter.ordersHolderClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class MyTrayActivity extends AppCompatActivity {

    RecyclerView mListview;
    Button placeOrder;
    TextView yourLocation,myLocation,changeAddress;
    ImageView changeAddressPencilBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tray);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.setLightStatusBar(this,"#FFFFFF");
        }

        setIdOfView();

        TextView toolBarTxt = findViewById(R.id.titleName);
        toolBarTxt.setText(getString(R.string.myTray));

        findViewById(R.id.backBtnImg).setVisibility(View.GONE);
        findViewById(R.id.closeImgBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishContext();
            }
        });

        recyclerViewSetupFirst();

    }

    private void setIdOfView(){
        mListview = findViewById(R.id.order_list_item_vertical);
        placeOrder = findViewById(R.id.placeOrder);
        yourLocation = findViewById(R.id.yourLocation);
        myLocation = findViewById(R.id.myLocation);
        changeAddress = findViewById(R.id.changeAddress);
        changeAddressPencilBtn = findViewById(R.id.changeAddressPencilBtn);
    }

    private void listSetHorizontal(RecyclerView listView){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        listView.setLayoutManager(linearLayoutManager);
    }

    private void listFixedSize(RecyclerView itemList){
        itemList.setHasFixedSize(true);
        itemList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void finishContext(){
        finish();
        overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
    }

    private void recyclerViewSetupSecond(){

        yourLocation.setVisibility(View.GONE);
        myLocation.setVisibility(View.VISIBLE);
        changeAddress.setVisibility(View.VISIBLE);
        changeAddressPencilBtn.setVisibility(View.VISIBLE);

        UtilClass.setDividerOnRecycler(mListview,this);

        ConfirmOrderModel[] confirmOrderModels = new ConfirmOrderModel[]{
                new ConfirmOrderModel("ABC",50.00,70.00,70.00,2),
                new ConfirmOrderModel("DEF",40.00,80.00,80.00,1),
        };

        ConfirmOrderAdapter confirmOrderAdapter = new ConfirmOrderAdapter(confirmOrderModels,this);

        listFixedSize(mListview);

        mListview.setAdapter(confirmOrderAdapter);
    }

    private void recyclerViewSetupFirst(){

        yourLocation.setVisibility(View.VISIBLE);
        myLocation.setVisibility(View.GONE);
        changeAddress.setVisibility(View.GONE);
        changeAddressPencilBtn.setVisibility(View.GONE);

        UtilClass.setDividerOnRecycler(mListview,this);

        ordersHolderClass[] ordersHolderClasses = new ordersHolderClass[]{
                new ordersHolderClass("ABC",50.00,70.00,70.00,1),
                new ordersHolderClass("DEF",40.00,80.00,80.00,1),
        };

        ordersAdapterClass ordersAdapterClass = new ordersAdapterClass(ordersHolderClasses,this);

        listFixedSize(mListview);

        mListview.setAdapter(ordersAdapterClass);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void placeOrderBtnOnClick(View view) {

        recyclerViewSetupSecond();

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popUpView = inflater.inflate(R.layout.hungry_popup_layout,null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;

        UtilClass.fullsreenui(this,"#99000000");

        Button addMoreDetails = popUpView.findViewById(R.id.AddMoredetails);
        Button cancelBtn = popUpView.findViewById(R.id.cancelBtn);

        final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        popupWindow.showAtLocation(view, Gravity.BOTTOM,0,0);

        popupWindow.setOutsideTouchable(false);

        addMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(MyTrayActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
                startActivity(new Intent(MyTrayActivity.this,delivery_address_confirmation.class),bndlAnimation);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilClass.fullsreenui(MyTrayActivity.this,"#FFFFFF");
                recyclerViewSetupFirst();
                popupWindow.dismiss();
            }
        });

    }
}
