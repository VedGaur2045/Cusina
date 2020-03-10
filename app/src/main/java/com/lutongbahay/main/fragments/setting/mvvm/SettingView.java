package com.lutongbahay.main.fragments.setting.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.setting.SettingFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingView extends FrameLayout {
    private final SettingViewModel viewModel;


    public SettingView(@NonNull Context context, SettingViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_setting,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.favDishes,R.id.msgAndNotification,R.id.closeImgBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.favDishes :
                Navigation.findNavController(view).navigate(SettingFragmentDirections.toFavouritesFragment());
                break;
            case R.id.msgAndNotification :
                Navigation.findNavController(view).navigate(SettingFragmentDirections.toInboxFragment());
                break;
            case R.id.closeImgBtn :
                Navigation.findNavController(view).navigateUp();
                break;
        }
    }

}
