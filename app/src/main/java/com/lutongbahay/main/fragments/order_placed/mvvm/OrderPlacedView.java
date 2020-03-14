package com.lutongbahay.main.fragments.order_placed.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.order_placed.OrderPlacedFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class OrderPlacedView extends FrameLayout {
    private final OrderPlacedViewModel viewModel;
    @BindView(R.id.backBtn)
    ImageButton backBtn;
    @BindView(R.id.backToMenuBtn)
    Button backToMenuBtn;

    public OrderPlacedView(@NonNull Context context, OrderPlacedViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_placed,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.backToMenuBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.backToMenuBtn){
            Navigation.findNavController(view).navigateUp();
        }
    }

}
