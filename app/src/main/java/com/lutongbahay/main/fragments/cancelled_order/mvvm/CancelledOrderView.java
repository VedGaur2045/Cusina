package com.lutongbahay.main.fragments.cancelled_order.mvvm;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.CancelledOrderRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CancelledOrderView extends FrameLayout {
    private final CancelledOrderViewModel viewModel;
    @BindView(R.id.cancelledListItem)
    RecyclerView cancelledListItem;

    public CancelledOrderView(@NonNull Context context, CancelledOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_cancelled_order,this);
        ButterKnife.bind(this,this);

        CancelledOrderRecyclerAdapter cancelledOrderRecyclerAdapter = new CancelledOrderRecyclerAdapter();
        cancelledListItem.setAdapter(cancelledOrderRecyclerAdapter);
    }
}
