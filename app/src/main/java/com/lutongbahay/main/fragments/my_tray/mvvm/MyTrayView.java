package com.lutongbahay.main.fragments.my_tray.mvvm;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ConfirmOrderRecyclerAdapter;
import com.lutongbahay.adapter.TrayOrderItemsAdapter;
import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;
import com.lutongbahay.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTrayView extends FrameLayout {
    private final MyTrayViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.yourLocation)
    TextView yourLocation;
    @BindView(R.id.myLocation)
    TextView myLocation;
    @BindView(R.id.changeAddress)
    TextView changeAddress;
    @BindView(R.id.firstAddress)
    TextView firstAddress;
    @BindView(R.id.secondAddress)
    TextView secondAddress;
    @BindView(R.id.addOtherAddress)
    TextView addOtherAddress;
    @BindView(R.id.changeAddressPencilBtn)
    ImageButton changeAddressPencilBtn;
    @BindView(R.id.myTrayListVertical)
    RecyclerView myTrayListVertical;
    @BindView(R.id.totalAmount)
    TextView totalAmount;
    @BindView(R.id.placeOrder)
    TextView placeOrder;

    public MyTrayView(@NonNull Context context, MyTrayViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_my_tray,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.myTray);

        changeAddressPencilBtn.setVisibility(GONE);
        myLocation.setVisibility(GONE);
        changeAddress.setVisibility(GONE);

        StatusBarUtils.setLightStatusBar((Activity) context,"#FFFFFF");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = context.getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.WHITE);
//        }


        TrayOrderItemsAdapter trayOrderItemsAdapter = new TrayOrderItemsAdapter();
        myTrayListVertical.setAdapter(trayOrderItemsAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.closeImgBtn,R.id.placeOrder})
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(MyTrayFragmentDirections.toHomeFragment());
        } else if(id == R.id.placeOrder){
            placeOrderBtnOnClick(view);
        }
    }

    public void placeOrderBtnOnClick(View view) {

        yourLocation.setVisibility(View.GONE);
        myLocation.setVisibility(View.VISIBLE);
        changeAddress.setVisibility(View.VISIBLE);
        changeAddressPencilBtn.setVisibility(View.VISIBLE);

        ConfirmOrderRecyclerAdapter confirmOrderRecyclerAdapter = new ConfirmOrderRecyclerAdapter();
        myTrayListVertical.setAdapter(confirmOrderRecyclerAdapter);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        final View popUpView = inflater.inflate(R.layout.custom_popup_hungry,null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;

        Button addMoreDetails = popUpView.findViewById(R.id.AddMoredetails);
        Button cancelBtn = popUpView.findViewById(R.id.cancelBtn);

        final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        popupWindow.showAtLocation(view, Gravity.BOTTOM,0,0);

        popupWindow.setOutsideTouchable(false);

        addMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAddressPencilBtn.setVisibility(GONE);
                myLocation.setVisibility(GONE);
                changeAddress.setVisibility(GONE);
                yourLocation.setVisibility(View.VISIBLE);
                Navigation.findNavController(view).navigate(MyTrayFragmentDirections.toDelAddress());
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAddressPencilBtn.setVisibility(GONE);
                myLocation.setVisibility(GONE);
                changeAddress.setVisibility(GONE);
                yourLocation.setVisibility(View.VISIBLE);
                popupWindow.dismiss();
                TrayOrderItemsAdapter trayOrderItemsAdapter = new TrayOrderItemsAdapter();
                myTrayListVertical.setAdapter(trayOrderItemsAdapter);
            }
        });

    }

}
