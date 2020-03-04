package com.lutongbahay.main.fragments.choose_category.mvvm;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lutongbahay.R;

import butterknife.BindView;

public class ChooseCategoryView extends FrameLayout {
    private final ChooseCategoryViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.imageFirst)
    ImageView imageFirst;
    @BindView(R.id.imageSecond)
    ImageView imageSecond;
    @BindView(R.id.imageThird)
    ImageView imageThird;
    @BindView(R.id.searchViewHome)
    SearchView searchViewHome;
    @BindView(R.id.listView)
    ListView listView;

    public ChooseCategoryView(@NonNull Context context, ChooseCategoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
    }
}
