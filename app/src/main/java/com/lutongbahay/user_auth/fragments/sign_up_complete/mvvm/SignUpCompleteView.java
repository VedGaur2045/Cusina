package com.lutongbahay.user_auth.fragments.sign_up_complete.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragment;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragmentDirections;
import com.lutongbahay.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpCompleteView extends FrameLayout {
    private final SignUpCompleteViewModel viewModel;

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.backToHome)
    Button backToHome;
    @BindView(R.id.addAnotherLuto)
    Button addAnotherLuto;

    public SignUpCompleteView(@NonNull Context context, SignUpCompleteViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_sign_up_complete,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.backToHome,R.id.addAnotherLuto,R.id.back})
    public void onClick(View view){
        int id = view.getId();
        switch (id) {
            case R.id.back :
            case R.id.backToHome :
                HomeActivity.openHomeActivity(getContext());
                break;
            case R.id.addAnotherLuto :
                Constants.openProfile = true;
                HomeActivity.openHomeActivity(getContext());
                break;
        }
    }

}
