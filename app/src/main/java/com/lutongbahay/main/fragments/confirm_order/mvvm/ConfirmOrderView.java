package com.lutongbahay.main.fragments.confirm_order.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ConfirmOrderRecyclerAdapter;
import com.lutongbahay.main.fragments.confirm_order.ConfirmOrderFragment;
import com.lutongbahay.main.fragments.confirm_order.ConfirmOrderFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ConfirmOrderView extends FrameLayout {
    private final ConfirmOrderViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.customerNameTxt)
    TextView customerNameTxt;
    @BindView(R.id.customerEmailTxt)
    TextView customerEmailTxt;
    @BindView(R.id.customerPhoneTxt)
    TextView customerPhoneTxt;
    @BindView(R.id.changeAddressPencilBtn)
    ImageButton changeAddressPencilBtn;
    @BindView(R.id.firstAddress)
    TextView firstAddress;
    @BindView(R.id.secondAddress)
    TextView secondAddress;
    @BindView(R.id.addOtherAddress)
    TextView addOtherAddress;
    @BindView(R.id.order_list_item_vertical)
    RecyclerView order_list_item_vertical;
    @BindView(R.id.totalAmount)
    TextView totalAmount;
    @BindView(R.id.buyNow)
    Button buyNow;

    public ConfirmOrderView(@NonNull Context context, ConfirmOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_confirm_order, this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.confirmOrder);
        backBtnImg.setVisibility(GONE);

        ConfirmOrderRecyclerAdapter confirmOrderRecyclerAdapter = new ConfirmOrderRecyclerAdapter();
        order_list_item_vertical.setAdapter(confirmOrderRecyclerAdapter);
    }

    @OnClick(R.id.buyNow)
    public void onClick(View v){
        int id = v.getId();
        switch (id) {
            case R.id.buyNow:
                Navigation.findNavController(v).navigate(ConfirmOrderFragmentDirections.toPaymentMethod());
                break;
            case R.id.closeImgBtn:
                Navigation.findNavController(v).navigate(ConfirmOrderFragmentDirections.toDeliveryAddressFragment());
                break;
        }
    }

}
