package com.lutongbahay.main.fragments.favourites.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.VerticalHomeFoodMenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FavouritesView extends FrameLayout {
    private final FavouriteViewModel viewModel;
    Context context;
    @BindView(R.id.favDishListView)
    RecyclerView favrouiteRecyclerView;
    @BindView(R.id.titleName)
    TextView titleName;


    public FavouritesView(@NonNull Context context, FavouriteViewModel viewModel,int Check,String titleNameTxt) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_favourites, this);
        ButterKnife.bind(this, this);
        try{
            if(Check == 11){
                titleName.setText(titleNameTxt);
            } else if(Check == 12){
                titleName.setText(titleNameTxt);
            } else if(Check == 13){
                titleName.setText(titleNameTxt);
            } else if(Check == 14){
                titleName.setText(titleNameTxt);
            } else {
                titleName.setText(R.string.favouriteTxt);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        VerticalHomeFoodMenuAdapter verticalHomeFoodMenuAdapter = new VerticalHomeFoodMenuAdapter(0);
        favrouiteRecyclerView.setAdapter(verticalHomeFoodMenuAdapter);

    }

    @OnClick(R.id.closeImgBtn)
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.closeImgBtn) {
            Navigation.findNavController(view).navigateUp();
        }
    }

}
