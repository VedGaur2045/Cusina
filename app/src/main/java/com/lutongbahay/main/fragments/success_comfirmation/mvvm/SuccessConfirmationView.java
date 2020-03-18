package com.lutongbahay.main.fragments.success_comfirmation.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.success_comfirmation.SuccessConfirmationFragment;
import com.lutongbahay.main.fragments.success_comfirmation.SuccessConfirmationFragmentDirections;
import com.lutongbahay.main.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuccessConfirmationView extends FrameLayout {
    private final SuccessConfirmationViewModel viewModel;
    @BindView(R.id.backBtn)
    ImageButton backBtn;
    @BindView(R.id.backToHomeBtn)
    Button backToHomeBtn;
    @BindView(R.id.addanotherluto)
    Button addanotherluto;

    public SuccessConfirmationView(@NonNull Context context, SuccessConfirmationViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_success_confirmation,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.backBtn)
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backBtn :
                Navigation.findNavController(view).navigateUp();
                break;
            case R.id.backToHomeBtn :
                Navigation.findNavController(view).navigate(SuccessConfirmationFragmentDirections.toHomeFragment());
                break;
            case R.id.addanotherluto:
                Navigation.findNavController(view).navigate(SuccessConfirmationFragmentDirections.toAddPhoto());
                break;
        }
    }

}
