package com.lutongbahay.main.fragments.earn_rewards.mvvm;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

import butterknife.ButterKnife;

public class EarnRewardsView extends FrameLayout {
    private final EarnRewardsViewModel viewModel;

    public EarnRewardsView(@NonNull Context context, EarnRewardsViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_earn_rewards,this);
        ButterKnife.bind(this,this);
    }
}
