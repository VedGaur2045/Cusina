package com.lutongbahay.main.fragments.message_location.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.message_location.MessageLocationFragment;
import com.lutongbahay.main.fragments.message_location.MessageLocationFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageLocationView extends FrameLayout {
    private final MessageLocationViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.deliverAwayId)
    TextView deliverAwayId;
    @BindView(R.id.showOrderDetails)
    TextView showOrderDetails;

    public MessageLocationView(@NonNull Context context, MessageLocationViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_message_location,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.backBtnImg)
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.backBtnImg){
            Navigation.findNavController(v).navigate(MessageLocationFragmentDirections.toInboxFragment());
        } else if(id == R.id.showOrderDetails){
            Navigation.findNavController(v).navigate(MessageLocationFragmentDirections.toMyOrdersFragment());
        }
    }
}
