package com.lutongbahay.main.fragments.home_frag.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.MainHomeFoodMenuAdapter;
import com.lutongbahay.main.fragments.home_frag.HomeFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class HomeFragView extends FrameLayout {
    private final HomeFragViewModel viewModel;

    @BindView(R.id.food_menu_rv)
    RecyclerView foodMenuRv;

    @BindView(R.id._trayOnHome)
    RelativeLayout trayHome;


    public HomeFragView(@NonNull Context context, HomeFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_home, this);
        ButterKnife.bind(this, this);

        MainHomeFoodMenuAdapter mainHomeFoodMenuAdapter = new MainHomeFoodMenuAdapter(getContext());
        foodMenuRv.setAdapter(mainHomeFoodMenuAdapter);

        trayHome.setOnClickListener(v -> Navigation.findNavController(v).navigate(HomeFragmentDirections.openCartFragment()));


    }
}
