package com.lutongbahay.main.fragments.Otp_Frag.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.chaos.view.PinView;
import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.main.fragments.Otp_Frag.OtpBasedFragmentDirections;
import com.lutongbahay.user_auth.activity.SplashActivity;
import com.lutongbahay.utils.SnackbarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtpBasedView extends FrameLayout {
    private final OtpBasedViewModel viewModel;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.resendOTP)
    TextView resendOTP;
    @BindView(R.id.otp_view)
    PinView otp_view;
    @BindView(R.id.nextBtn)
    Button nextBtn;

    public OtpBasedView(@NonNull Context context, OtpBasedViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_otp_based,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.closeImgBtn,R.id.resendOTP,R.id.nextBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.closeImgBtn:
                SplashActivity.openSplashActivity(getContext());
                break;
            case R.id.nextBtn:
                if (otp_view.getText().toString().isEmpty()){
                    SnackbarUtils.showSnackBar(view,"Please enter the otp...", Snackbar.LENGTH_LONG);
                } else {
                    Navigation.findNavController(view).navigate(OtpBasedFragmentDirections.toPrivacyFragment());
                }
                break;
            case R.id.resendOTP:
                break;
        }
    }

}
