package com.lutongbahay.user_auth.fragments.sign_up.mvvm;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpView extends FrameLayout {
    private final SignUpViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.usermobile)
    EditText usermobile;
    @BindView(R.id.useremail)
    EditText useremail;
    @BindView(R.id.useradddressline1)
    EditText useradddressline1;
    @BindView(R.id.useradddressline2)
    EditText useradddressline2;
    @BindView(R.id.citylist)
    Spinner citylist;
    @BindView(R.id.zipcode)
    EditText zipcode;
    @BindView(R.id.usercountry)
    EditText usercountry;
    @BindView(R.id.genderlist)
    Spinner genderlist;
    @BindView(R.id.NextBtn)
    Button NextBtn;

    public SignUpView(@NonNull Context context, SignUpViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_sign_up,this);
        ButterKnife.bind(this,this);
    }
}
