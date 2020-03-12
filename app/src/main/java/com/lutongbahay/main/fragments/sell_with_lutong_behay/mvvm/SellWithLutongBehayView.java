package com.lutongbahay.main.fragments.sell_with_lutong_behay.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.sell_with_lutong_behay.SellWithLutongBehayFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellWithLutongBehayView extends FrameLayout {
    private final SellWithLutongBehayViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.signUpBtn)
    Button signUpBtn;

    public SellWithLutongBehayView(@NonNull Context context, SellWithLutongBehayViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_sell_with_lutong_behay,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.signUpBtn,R.id.backBtnImg})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.signUpBtn){
            Navigation.findNavController(view).navigate(SellWithLutongBehayFragmentDirections.toSignUpFragment());
        } else if(id == R.id.backBtnImg){
            Navigation.findNavController(view).navigate(SellWithLutongBehayFragmentDirections.toProfileFragment());
        }
    }

}
