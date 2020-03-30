package com.lutongbahay.main.fragments.item_detail.mvvm;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutongbahay.R;
import com.lutongbahay.adapter.DateOfOrderRecyclerAdapter;
import com.lutongbahay.adapter.SliderAdapter;
import com.lutongbahay.adapter.TimeOfPickupOrderRecyclerAdapter;
import com.lutongbahay.dialogs.AppAction;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.main.fragments.item_detail.ItemDetailFragmentDirections;
import com.lutongbahay.utils.Logger;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class ItemDetailView extends FrameLayout {

    private final ItemDetailViewModel viewModel;
    @BindView(R.id.backBtnImg)
    ImageView backBtnImg;
    @BindView(R.id.productImgItem)
    ImageView productImgItem;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productServingLeftCount)
    TextView ServingLeftCount;
    @BindView(R.id.productRatingCount)
    TextView productRatingCount;
    @BindView(R.id.productPrice)
    TextView productPrice;
    @BindView(R.id.productPlaceName)
    TextView productPlaceName;
    @BindView(R.id.productDelTime)
    TextView productDelTime;
    @BindView(R.id.productDeliveryFee)
    TextView productDeliveryFee;
    @BindView(R.id.productDeliveryPickUp)
    TextView productDeliveryPickUp;
    @BindView(R.id.productMinimumOrderCount)
    TextView productMinimumOrderCount;
    @BindView(R.id.descriptionTxt)
    TextView descriptionTxt;
    @BindView(R.id.seeProfile)
    TextView seeProfile;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.ownerKitchenTxt)
    TextView ownerKitchenTxt;
    @BindView(R.id.ownerNameTxt)
    TextView ownerNameTxt;
    @BindView(R.id.productRatingCountSecond)
    TextView productRatingCountSecond;
    @BindView(R.id.minusBtn)
    RelativeLayout minusBtn;
    @BindView(R.id.plusBtn)
    RelativeLayout plusBtn;
    @BindView(R.id.quantityProduct)
    TextView quantityProduct;
    @BindView(R.id.addToTrayBtn)
    Button addToTrayBtn;
    @BindView(R.id.previousBtn)
    ImageButton previousBtn;
    @BindView(R.id.nextBtn)
    ImageButton nextBtn;
    @BindView(R.id.dateListItem)
    RecyclerView dateListItem;
    @BindView(R.id.timeListItem)
    RecyclerView timeListItem;
    @BindView(R.id.pagerSlider)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    TabLayout tabLayout;

    private static int COUNT = 1;
    private int currentPage = 0;
    private int NUM_PAGES = 0;

    private ArrayList<String> imageArray = new ArrayList<>();
    private ArrayList<String> images=new ArrayList<>();
    private int[] imageSell = {R.mipmap.product_img_item,R.mipmap.product_img,R.mipmap.maestro_img};

    public ItemDetailView(@NonNull AppCompatActivity context, ItemDetailViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_item_detail,this);
        ButterKnife.bind(this,this);

        LinearLayoutManager horizontalLayoutManager= new LinearLayoutManager((Context) context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManagerDef= new LinearLayoutManager((Context) context, LinearLayoutManager.HORIZONTAL, false);

        dateListItem.setLayoutManager(horizontalLayoutManager);
        timeListItem.setLayoutManager(horizontalLayoutManagerDef);

        DateOfOrderRecyclerAdapter dateOfOrderRecyclerAdapter = new DateOfOrderRecyclerAdapter();
        TimeOfPickupOrderRecyclerAdapter timeOfPickupOrderRecyclerAdapter = new TimeOfPickupOrderRecyclerAdapter();

        dateListItem.setAdapter(dateOfOrderRecyclerAdapter);
        timeListItem.setAdapter(timeOfPickupOrderRecyclerAdapter);

    }

    @OnClick({R.id.addToTrayBtn,R.id.backBtnImg,R.id.ratingImg,R.id.minusBtn,R.id.plusBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.addToTrayBtn:
            case R.id.backBtnImg:
                Navigation.findNavController(view).navigateUp();
                break;
            case R.id.ratingImg:
                Navigation.findNavController(view).navigate(ItemDetailFragmentDirections.toDishReviewFragment());
                break;
            case R.id.plusBtn:
                AppAction.addCount(COUNT,quantityProduct);
                break;
            case R.id.minusBtn:
                AppAction.minusCount(COUNT,quantityProduct);
                break;
        }
    }


    private void init(ArrayList<String> imageArr) {

        currentPage=0;
        NUM_PAGES=0;

        int i;
        for(i=0;i<imageArr.size();i++){
            imageArray.add(imageArr.get(i));
        }

        viewPager.setAdapter(new SliderAdapter(imageArray,getContext()));

        tabLayout.setupWithViewPager(viewPager);

        NUM_PAGES = imageArray.size();

        // Pager listener over indicator
        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentPage = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void dishDetail(AppCompatActivity context,int  itemid, String token,double Lat,double Long ){
        viewModel.dishDetail(context, itemid,token,Lat,Long).observe(context, responseDishDetail -> {
            if(responseDishDetail == null){
                showErrorAlert(context,"Dish details not found!","Error");
            } else {
                if (!responseDishDetail.getSuccess()){
                    showErrorAlert(context,responseDishDetail.getMessage(),"Message");
                } else {
                    for(int i=0;i<responseDishDetail.getData().getImages().size();i++){
                        images.add(String.valueOf(responseDishDetail.getData().getImages().get(i)));
                    }
                    init(images);
                    productPlaceName.setText(responseDishDetail.getData().getName());
                    productDeliveryFee.setText(responseDishDetail.getData().getDeliveryPrice());
                    productPrice.setText(responseDishDetail.getData().getPrice());
                    descriptionTxt.setText(responseDishDetail.getData().getDescription());
                    productRatingCount.setText(responseDishDetail.getData().getRating());
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    public void showErrorAlert(Context context, String errorMessage, String title) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, title, errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
