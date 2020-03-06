package com.lutongbahay.main.fragments.orders.mvvm;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersView extends FrameLayout {
    private final OrdersViewModel viewModel;

    @BindView(R.id.ordersListItem)
    RecyclerView ordersListItem;

    public OrdersView(@NonNull Context context, OrdersViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_orders,this);
        ButterKnife.bind(this,this);
    }
}
