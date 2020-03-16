package com.lutongbahay.main.fragments.dish_reviews.mvvm;

import android.content.Context;
import android.media.Rating;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.DishReviewRecyclerAdapter;
import com.lutongbahay.main.fragments.dish_reviews.DishReviewFragment;
import com.lutongbahay.main.fragments.dish_reviews.DishReviewFragmentDirections;
import com.lutongbahay.utils.RatingBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DishReviewView extends FrameLayout {
    private final DishReviewViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.givenAllReviewCount)
    TextView givenAllReviewCount;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.allReviewByUserCount)
    TextView allReviewByUserCount;
    @BindView(R.id.RateServer)
    TextView RateServer;
    @BindView(R.id._1_review_total_count)
    TextView _1_review_total_count;
    @BindView(R.id._2_review_total_count)
    TextView _2_review_total_count;
    @BindView(R.id._3_review_total_count)
    TextView _3_review_total_count;
    @BindView(R.id._4_review_total_count)
    TextView _4_review_total_count;
    @BindView(R.id._5_review_total_count)
    TextView _5_review_total_count;
    @BindView(R.id.reviewMsgListView)
    RecyclerView reviewMsgListView;

    public DishReviewView(@NonNull Context context, DishReviewViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_dish_review,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.Reviews);
        backBtnImg.setVisibility(GONE);

        float rate = Float.parseFloat(givenAllReviewCount.getText().toString());
        System.out.println(rate);
        ratingBar.setRating(rate);

        DishReviewRecyclerAdapter dishReviewRecyclerAdapter = new DishReviewRecyclerAdapter();
        reviewMsgListView.setAdapter(dishReviewRecyclerAdapter);

    }

    @OnClick({R.id.closeImgBtn,R.id.ratingBar})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(DishReviewFragmentDirections.toHomeFragment());
            //Navigation.findNavController(view).navigate(DishReviewFragmentDirections.openItemDetailFragment());
        }
    }



}
