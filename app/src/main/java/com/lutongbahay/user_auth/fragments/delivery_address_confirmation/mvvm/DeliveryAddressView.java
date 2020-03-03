package com.lutongbahay.user_auth.fragments.delivery_address_confirmation.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.delivery_address_confirmation.DeliveryAddressConfirmationFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class DeliveryAddressView extends FrameLayout {
    private final DeliveryAddressViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userEmailId)
    EditText userEmailId;
    @BindView(R.id.addressTxt)
    EditText addressTxt;
    @BindView(R.id.saveDetails)
    Button saveDetails;

    public DeliveryAddressView(@NonNull Context context, DeliveryAddressViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_delivery_address_confirmation,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.saveDetails)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.saveDetails){
            Navigation.findNavController(view).navigate(DeliveryAddressConfirmationFragmentDirections.toConfirmOrder());
        }
    }
}
