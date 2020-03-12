package com.lutongbahay.main.fragments.completed_order.mvvm;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.CancelledOrderRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class CompletedOrderView extends FrameLayout {
    private final CompletedOrderViewModel viewModel;
    @BindView(R.id.completedListItem)
    RecyclerView completedListItem;

    public CompletedOrderView(@NonNull Context context, CompletedOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_completed_order,this);
        ButterKnife.bind(this,this);
        /*
        * CancelledOrderRecyclerAdapter cancelledOrderRecyclerAdapter = new CancelledOrderRecyclerAdapter();
        * Complete order list*/
        CancelledOrderRecyclerAdapter cancelledOrderRecyclerAdapter = new CancelledOrderRecyclerAdapter();
        completedListItem.setAdapter(cancelledOrderRecyclerAdapter);
    }
}
