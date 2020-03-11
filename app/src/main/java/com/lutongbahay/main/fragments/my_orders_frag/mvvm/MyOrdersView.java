package com.lutongbahay.main.fragments.my_orders_frag.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;
import com.lutongbahay.adapter.OrderTabsViewPagerAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.main.fragments.cancelled_order.CancelledOrderFragment;
import com.lutongbahay.main.fragments.completed_order.CompletedOrderFragment;
import com.lutongbahay.main.fragments.processing_order.ProcessingOrderFragment;

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
    Context context;


    public MyOrdersView(@NonNull Context context, MyOrdersViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        this.context = context;
        inflate(context, R.layout.fragment_my_orders, this);
        ButterKnife.bind(this, this);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.closeImgBtn)
    public void onViewClicked() {
    }

    private void setupViewPager(ViewPager viewPager) {
        OrderTabsViewPagerAdapter adapter = new OrderTabsViewPagerAdapter(((AppCompatActivity) context).getSupportFragmentManager());
        adapter.addFragment(new ProcessingOrderFragment(), CusinaApplication.getInstance().getResources().getString(R.string.Processing));
        adapter.addFragment(new CompletedOrderFragment(), CusinaApplication.getInstance().getResources().getString(R.string.Completed));
        adapter.addFragment(new CancelledOrderFragment(), CusinaApplication.getInstance().getResources().getString(R.string.Cancelled));
        viewPager.setAdapter(adapter);
    }
}
