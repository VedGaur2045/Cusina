package com.lutongbahay.main.fragments.payment_method.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.payment_method.PaymentMethodFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class PaymentMethodView extends FrameLayout {
    private final PaymentMethodViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.paymentMethodList)
    ListView paymentMethodList;
    @BindView(R.id.Total_Amt_price)
    TextView Total_Amt_price;
    @BindView(R.id.subTotal_price)
    TextView subTotal_price;
    @BindView(R.id.payNowBtn)
    Button payNowBtn;

    public PaymentMethodView(@NonNull Context context, PaymentMethodViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_payment_method,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.payNowBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.payNowBtn){
            Navigation.findNavController(view).navigate(PaymentMethodFragmentDirections.toOrderPlaced());
        }
    }

}
