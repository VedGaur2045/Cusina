package com.lutongbahay.main.fragments.my_tray.mvvm;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

import butterknife.ButterKnife;

public class MyTrayView extends FrameLayout {
    private final MyTrayViewModel viewModel;


    public MyTrayView(@NonNull Context context, MyTrayViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_my_tray,this);
        ButterKnife.bind(this,this);
    }
}
