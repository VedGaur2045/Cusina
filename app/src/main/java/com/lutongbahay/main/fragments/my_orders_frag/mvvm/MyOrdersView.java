package com.lutongbahay.main.fragments.my_orders_frag.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class MyOrdersView extends FrameLayout {
    private final MyOrdersViewModel viewModel;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.custom_toolbar)
    RelativeLayout customToolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    public MyOrdersView(@NonNull Context context, MyOrdersViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_my_orders, this);
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.closeImgBtn)
    public void onViewClicked() {
    }
}
