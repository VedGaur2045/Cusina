package com.lutongbahay.main.fragments.delivery_address_confirmation.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.main.fragments.delivery_address_confirmation.DeliveryAddressConfirmationFragmentDirections;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.TextUtils;

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

        titleName.setText(R.string.myDetails);
        backBtnImg.setVisibility(GONE);

    }

    @OnClick(R.id.saveDetails)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.saveDetails){
            if (username.getText().toString().equalsIgnoreCase("")){
                SnackbarUtils.showSnackBar(view,"Please enter name",Snackbar.LENGTH_LONG);
            }else if (userEmailId.getText().toString().equalsIgnoreCase("")){
                SnackbarUtils.showSnackBar(view,"Please enter email",Snackbar.LENGTH_LONG);
            }else if (!TextUtils.isEmailIdValid(userEmailId.getText().toString())) {
                SnackbarUtils.showSnackBar(view, "Please ente validr email", Snackbar.LENGTH_LONG);
            }else if (addressTxt.getText().toString().equalsIgnoreCase("")){
                SnackbarUtils.showSnackBar(view,"Please enter address",Snackbar.LENGTH_LONG);
            }else{
                Navigation.findNavController(view).navigate(DeliveryAddressConfirmationFragmentDirections.toConfirmOrder());
            }
        } else if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigateUp();
        }
    }
}
