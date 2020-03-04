package com.lutongbahay.main.fragments.add_photo.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddPhotoView extends FrameLayout {
    private final AddPhotoViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.allPhoto)
    TextView allPhoto;
    @BindView(R.id.next)
    TextView next;
    @BindView(R.id.gridViewGalleryPhotoList)
    GridView gridViewGalleryPhotoList;

    public AddPhotoView(@NonNull Context context, AddPhotoViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.adapter_add_photo,this);
        ButterKnife.bind(this,this);
    }
}
