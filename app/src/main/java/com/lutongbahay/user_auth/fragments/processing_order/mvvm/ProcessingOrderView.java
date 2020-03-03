package com.lutongbahay.user_auth.fragments.processing_order.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ProcessingOrderView extends FrameLayout {
    private final ProcessingOrderViewModel viewModel;
    @BindView(R.id.orderNumber)
    TextView orderNumber;
    @BindView(R.id.orderDate)
    TextView orderDate;
    @BindView(R.id.ServerTxt)
    TextView ServerTxt;
    @BindView(R.id.processingListItem)
    RecyclerView processingListItem;

    public ProcessingOrderView(@NonNull Context context, ProcessingOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_processing_order,this);
        ButterKnife.bind(this,this);
    }
}
