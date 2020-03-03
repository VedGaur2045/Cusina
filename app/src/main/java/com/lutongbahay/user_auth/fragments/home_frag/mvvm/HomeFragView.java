package com.lutongbahay.user_auth.fragments.home_frag.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class HomeFragView extends FrameLayout {
    private final HomeFragViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.searchViewHome)
    SearchView searchViewHome;
    @BindView(R.id.list_item_vertical)
    RecyclerView list_item_vertical;
    @BindView(R.id.list_item_horizontal_first)
    RecyclerView list_item_horizontal_first;
    @BindView(R.id.list_item_horizontal_second)
    RecyclerView list_item_horizontal_second;
    @BindView(R.id.second_list_item_vertical)
    RecyclerView second_list_item_vertical;
    @BindView(R.id.seeMoretxt)
    TextView seeMoretxt;
    @BindView(R.id.seeMoreDishtxt)
    TextView seeMoreDishtxt;
    @BindView(R.id.seeMorePalutoDishtxt)
    TextView seeMorePalutoDishtxt;
    @BindView(R.id.seeMoreSecondDishtxt)
    TextView seeMoreSecondDishtxt;
    @BindView(R.id._trayOnHome)
    RelativeLayout _trayOnHome;
    @BindView(R.id.firstDishGroupTxt)
    TextView firstDishGroupTxt;
    @BindView(R.id.firstDishGroupTxtShort)
    TextView firstDishGroupTxtShort;
    @BindView(R.id.secondTxtDish)
    TextView secondTxtDish;
    @BindView(R.id.PalutoDishesTxt)
    TextView PalutoDishesTxt;
    @BindView(R.id.PalutoDishesTxtShort)
    TextView PalutoDishesTxtShort;
    @BindView(R.id.nearMeDishesTxt)
    TextView nearMeDishesTxt;
    @BindView(R.id.nearMeDishesTxtShort)
    TextView nearMeDishesTxtShort;
    @BindView(R.id.trayCount)
    TextView trayCount;

    public HomeFragView(@NonNull Context context, HomeFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_home,this);
        ButterKnife.bind(this,this);
    }
}
