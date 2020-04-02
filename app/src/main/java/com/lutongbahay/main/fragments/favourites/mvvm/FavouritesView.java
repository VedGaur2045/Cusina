package com.lutongbahay.main.fragments.favourites.mvvm;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.FavouriteDishesAdapter;
import com.lutongbahay.adapter.VerticalHomeFoodMenuAdapter;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.StatusBarUtils;

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

    FavouriteDishesAdapter favouriteDishesAdapter;

    public FavouritesView(@NonNull Context context, FavouriteViewModel viewModel,int Check,String titleNameTxt) {
        super(context);
        this.context = context;
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_favourites, this);
        ButterKnife.bind(this, this);

        //        LinearLayoutManager verticalLayoutManager= new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true);
//        favrouiteRecyclerView.setHasFixedSize(true);
//        favrouiteRecyclerView.setLayoutManager(verticalLayoutManager);
     //   try{
            if(Check == 11){
                titleName.setText(titleNameTxt);
                seeAllDishesNearMe(Constants.LAT,Constants.LNG,Constants.TOKEN);
            } else if(Check == 12){
                titleName.setText(titleNameTxt);
                seeAllDishesTopRated(Constants.LAT,Constants.LNG,Constants.TOKEN);
            } else if(Check == 13){
                titleName.setText(titleNameTxt);
                seeAllDishesPreOrdered(Constants.LAT,Constants.LNG,Constants.TOKEN);
            } else if(Check == 14){
                titleName.setText(titleNameTxt);
                seeAllDishesScheduleMeals(Constants.LAT,Constants.LNG,Constants.TOKEN);
            } else {
                titleName.setText(R.string.favouriteTxt);
                seeAllDishesNearMe(Constants.LAT,Constants.LNG,Constants.TOKEN);
            }
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }

    }

    @OnClick(R.id.closeImgBtn)
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.closeImgBtn) {
            Navigation.findNavController(view).navigateUp();
        }
    }

    public void showErrorAlert(Context context, String errorMessage, String title) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, title, errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

    private void seeAllDishesNearMe(double lat, double lng, String token){
        viewModel.seeAllDishesNearMe(context,token,lat,lng).observe((AppCompatActivity) context, responseSeeAllDishes -> {
            if(responseSeeAllDishes == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.","Error");
            } else {
                System.out.println("dfkhknb : "+responseSeeAllDishes.getData().size());
                FavouriteDishesAdapter favouriteDishesAdapter = new FavouriteDishesAdapter(1, responseSeeAllDishes.getData());
                favrouiteRecyclerView.setAdapter(favouriteDishesAdapter);
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    private void seeAllDishesTopRated(double lat, double lng, String token){
        viewModel.seeAllDishesTopRated(context,token,lat,lng).observe((AppCompatActivity) context, responseSeeAllDishes -> {
            if(responseSeeAllDishes == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.","Error");
            } else {
                favouriteDishesAdapter = new FavouriteDishesAdapter(1, responseSeeAllDishes.getData());
                favrouiteRecyclerView.setAdapter(favouriteDishesAdapter);
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }
    private void seeAllDishesPreOrdered(double lat, double lng, String token){
        viewModel.seeAllDishesPreOrdered(context,token,lat,lng).observe((AppCompatActivity) context, responseSeeAllDishes -> {
            if(responseSeeAllDishes == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.","Error");
            } else {
                favouriteDishesAdapter = new FavouriteDishesAdapter(1, responseSeeAllDishes.getData());
                favrouiteRecyclerView.setAdapter(favouriteDishesAdapter);
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }
    private void seeAllDishesScheduleMeals(double lat, double lng, String token){
        viewModel.seeAllDishesScheduleMeals(context,token,lat,lng).observe((AppCompatActivity) context, responseSeeAllDishes -> {
            if(responseSeeAllDishes == null){
                showErrorAlert(context, "Oops!! Server error occurred. Please try again.","Error");
            } else {
                favouriteDishesAdapter = new FavouriteDishesAdapter(1, responseSeeAllDishes.getData());
                favrouiteRecyclerView.setAdapter(favouriteDishesAdapter);
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

}
