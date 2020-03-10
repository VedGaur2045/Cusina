package com.lutongbahay.main.fragments.profile_frag.mvvm;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragView extends FrameLayout {
    private final ProfileFragViewModel viewModel;
    @BindView(R.id.userImage)
    ImageView userImage;
    @BindView(R.id.heartImg)
    ImageView heartImg;
    @BindView(R.id.chatImg)
    ImageView chatImg;

    @BindView(R.id.setting)
    RelativeLayout settings;

    public ProfileFragView(@NonNull Context context, ProfileFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_profile,this);
        ButterKnife.bind(this,this);

        settings.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(ProfileFragmentDirections.openSettings());
        });
    }
}
