package com.lutongbahay.main.fragments.choose_category.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ChooseCategoryRecyclerAdapter;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    RecyclerView listView;

    public ChooseCategoryView(@NonNull Context context, ChooseCategoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_choose_category, this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.choose_category);
        closeImgBtn.setVisibility(GONE);

        ChooseCategoryRecyclerAdapter chooseCategoryRecyclerAdapter = new ChooseCategoryRecyclerAdapter();
        listView.setAdapter(chooseCategoryRecyclerAdapter);

    }

    @OnClick({R.id.backBtnImg,R.id.imageSecond,R.id.imageThird})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backBtnImg:
            case R.id.imageSecond:
            case R.id.imageThird:
                Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCameraFragment());
                break;
        }
    }

}
