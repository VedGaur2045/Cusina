package com.lutongbahay.user_auth.fragments.view_item.mvvm;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ViewItemView extends FrameLayout {

    private final ViewItemViewModel viewModel;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.productImgItem)
    ImageView productImgItem;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productServingLeftCount)
    TextView ServingLeftCount;
    @BindView(R.id.productRatingCount)
    TextView productRatingCount;
    @BindView(R.id.productPrice)
    TextView productPrice;
    @BindView(R.id.productPlaceName)
    TextView productPlaceName;
    @BindView(R.id.productDelTime)
    TextView productDelTime;
    @BindView(R.id.productDeliveryFee)
    TextView productDeliveryFee;
    @BindView(R.id.productDeliveryPickUp)
    TextView productDeliveryPickUp;
    @BindView(R.id.productMinimumOrderCount)
    TextView productMinimumOrderCount;
    @BindView(R.id.descriptionTxt)
    TextView descriptionTxt;
    @BindView(R.id.seeProfile)
    TextView seeProfile;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.ownerKitchenTxt)
    TextView ownerKitchenTxt;
    @BindView(R.id.ownerNameTxt)
    TextView ownerNameTxt;
    @BindView(R.id.productPreOrder)
    TextView productPreOrder;
    @BindView(R.id.productRatingCountSecond)
    TextView productRatingCountSecond;
    @BindView(R.id.minusBtn)
    RelativeLayout minusBtn;
    @BindView(R.id.plusBtn)
    RelativeLayout plusBtn;
    @BindView(R.id.quantityProduct)
    TextView quantityProduct;
    @BindView(R.id.addToTrayBtn)
    Button addToTrayBtn;

    public ViewItemView(@NonNull AppCompatActivity context, ViewItemViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_view_item,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.addToTrayBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.addToTrayBtn){
            Navigation.findNavController(view);
        }
    }

}
