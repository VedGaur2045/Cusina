package com.lutongbahay.main.fragments.profile_frag.mvvm;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.payment_method.PaymentMethodFragmentDirections;
import com.lutongbahay.main.fragments.profile_frag.ProfileFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.sellfood)
    RelativeLayout sellFood;
    @BindView(R.id.savedplace)
    RelativeLayout savedPlace;
    @BindView(R.id.fbbuuton)
    RelativeLayout fbButton;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.editprofile)
    TextView editProfile;
    @BindView(R.id.usermobile)
    TextView userMobile;
    @BindView(R.id.useremail)
    TextView userEmail;
    @BindView(R.id.AddNewLuto)
    TextView AddNewLuto;

    public ProfileFragView(@NonNull Context context, ProfileFragViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_profile,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.setting,R.id.sellfood,R.id.savedplace,R.id.fbbuuton,R.id.AddNewLuto})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.setting:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.openSettings());
                break;
            case R.id.sellfood:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.SellFood());
                break;
            case R.id.savedplace:
            case R.id.fbbuuton:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.FbConnect());
                break;
            case R.id.AddNewLuto:
                Navigation.findNavController(view).navigate(ProfileFragmentDirections.toAddPhoto());
                break;
        }
    }
}
