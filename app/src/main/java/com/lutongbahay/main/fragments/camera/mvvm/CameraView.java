package com.lutongbahay.main.fragments.camera.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.main.fragments.camera.CameraFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class CameraView extends FrameLayout {
    private final CameraViewModel viewModel;
    @BindView(R.id.camera_preview)
    FrameLayout camera_preview;
    @BindView(R.id.indicator)
    TabLayout indicator;
    @BindView(R.id.sideBarBtn)
    ImageButton sideBarBtn;
    @BindView(R.id.timeBtn)
    ImageButton timeBtn;
    @BindView(R.id.hdrBtn)
    ImageButton hdrBtn;
    @BindView(R.id.gridIconBtn)
    ImageButton gridIconBtn;
    @BindView(R.id.tempBtn)
    ImageButton tempBtn;
    @BindView(R.id.flashAutoBtn)
    ImageButton flashAutoBtn;
    @BindView(R.id.capturedImage)
    CircleImageView capturedImage;
    @BindView(R.id.capturedImageBtn)
    ImageButton capturedImageBtn;
    @BindView(R.id.rightBtn)
    RelativeLayout rightBtn;

    public CameraView(@NonNull Context context, CameraViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_camera,this);
        ButterKnife.bind(this,this);
    }

    @OnClick({R.id.capturedImageBtn,R.id.rightBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.capturedImageBtn:
                Navigation.findNavController(view).navigate(CameraFragmentDirections.toAddPhoto());
                break;
            case R.id.rightBtn:
                Navigation.findNavController(view).navigate(CameraFragmentDirections.toChooseCategory());
                break;
        }
    }

}
