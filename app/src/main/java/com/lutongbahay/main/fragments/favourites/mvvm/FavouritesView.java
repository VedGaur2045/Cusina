package com.lutongbahay.main.fragments.favourites.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

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


    public FavouritesView(@NonNull Context context, FavouriteViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_favourites, this);
        ButterKnife.bind(this, this);

        VerticalHomeFoodMenuAdapter verticalHomeFoodMenuAdapter = new VerticalHomeFoodMenuAdapter();
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
