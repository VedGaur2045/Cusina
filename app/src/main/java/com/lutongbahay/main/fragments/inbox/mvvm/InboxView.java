package com.lutongbahay.main.fragments.inbox.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.inbox.InboxFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InboxView extends FrameLayout {
    private final InboxViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.inboxListView)
    RecyclerView inboxListView;

    public InboxView(@NonNull Context context, InboxViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_inbox,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.backBtnImg)
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.backBtnImg) {
            Navigation.findNavController(view).navigate(InboxFragmentDirections.toSettingsFragment());
        }
    }

}