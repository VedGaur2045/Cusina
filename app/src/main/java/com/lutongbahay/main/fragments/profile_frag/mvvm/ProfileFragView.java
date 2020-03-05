package com.lutongbahay.main.fragments.profile_frag.mvvm;

import android.content.Context;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

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
    ViewStub layout_stub;

    public ProfileFragView(@NonNull Context context, ProfileFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_profile,this);
        ButterKnife.bind(this,this);
    }
}
