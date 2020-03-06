package com.lutongbahay.main.fragments.order_complete.mvvm;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.orders.mvvm.OrdersViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderCompleteView extends FrameLayout {
    private final OrderCompleteViewModel viewModel;
    @BindView(R.id.back)
    ImageButton back;
    @BindView(R.id.backToOrdersBtn)
    Button backToOrdersBtn;
    @BindView(R.id.SeeOrderHistoryBtn)
    Button SeeOrderHistoryBtn;

    public OrderCompleteView(@NonNull Context context, OrderCompleteViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_complete,this);
        ButterKnife.bind(this,this);
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backToOrdersBtn:
                break;
            case R.id.SeeOrderHistoryBtn:
                break;
            case R.id.back:
                break;
        }
    }

}
